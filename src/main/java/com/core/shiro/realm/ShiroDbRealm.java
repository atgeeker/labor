package com.core.shiro.realm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.busi.domain.Role;
import com.busi.domain.User;
import com.core.shiro.service.RoleService;
import com.core.shiro.service.UserService;
import com.core.shiro.util.CreatePasswordUtil;

/**
 * 该类从principals中取得用户名称进行匹配,在principals中默认保存了当前登陆人的用户名称,从而将该用户的角色加入到作用域中;  
 * @author zzy
 *
 */
public class ShiroDbRealm extends AuthorizingRealm{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	@Autowired
	private CreatePasswordUtil createPasswordUtil;
	@Autowired
	private RoleService roleService;
	
	public ShiroDbRealm(CacheManager cacheManager){
		super(cacheManager);
	}
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		// 根据用户配置用户与权限  
        if (principal == null) {  
        	log.info("PrincipalCollection method argument cannot be null.");
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");  
        }  
        log.info("权限认证doGetAuthorizationInfo()");
        
        //String name = (String) getAvailablePrincipal(principal);  
        User user = (User)principal.getPrimaryPrincipal();
        String name = user.getUsername();
        Collection<String> roles = new ArrayList<String>();//角色
        Collection<String> permissions = new ArrayList<String>(); //权限 
        roles = this.makeRolesByUserName(name);
        if("admin".equals(name) || "manager".equals(name)){
			permissions.add("del");
		}

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
        // 为用户设置角色和权限  
        info.addRoles(roles);  
        info.addStringPermissions(permissions);  
        return info;  
	}
	/**
	 * 通过当前登陆用户的姓名查找到相应的用户的所有信息
	 * @param userName
	 * @return
	 */
	private Collection<String> makeRolesByUserName(String userName){
		List<Role> userRoles = roleService.findByUserName(userName);
		Collection<String> hasRoles = new HashSet<String>();
		for(Role role : userRoles){
			hasRoles.add(role.getCode());
		}
		return hasRoles;
	}
	
	
	 /**  
	  * 登录认证
     * 验证当前登录的Subject（即 用户）
     * 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */  
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authToken) throws AuthenticationException {
		
		log.info("--->登录认证doGetAuthenticationInfo()"); 
		//String name = (String)authToken.getPrincipal();
		
		UsernamePasswordToken token = (UsernamePasswordToken)authToken;
		//token.setRememberMe(false);
		String name = token.getUsername();
		if(log.isDebugEnabled()){
			log.debug("current login user: "+token.getUsername());
		}

		//根据用户输入的用户名从数据库中获取用户信息，包括密码
		User user = userService.getUserByUserName(name);
		if(null == user){
			throw new UnknownAccountException();//没有查询到用户
		}
		
		//String pwd = createPasswordUtil.createPassword(new String(token.getPassword()), user.getSalt(), 2);
		//token.setPassword(pwd.toCharArray());
		//System.out.println("username:"+token.getUsername()+";pwd:"+new String(token.getPassword()));
		
		//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user,//也可以传输username
				user.getPassword(),//密码
				ByteSource.Util.bytes(user.getSalt()),
				getName());
        return info;  
	}

}

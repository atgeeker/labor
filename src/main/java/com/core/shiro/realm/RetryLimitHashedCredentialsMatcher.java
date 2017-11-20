package com.core.shiro.realm;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能就是用来匹配用户登录使用的令牌和数据库中保存的用户信息是否匹配
 * 
 * @author zzy
 * 
 */
public class RetryLimitHashedCredentialsMatcher extends
		HashedCredentialsMatcher {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * 声明一个缓存接口，这个接口是Shiro缓存管理的一部分，它的具体实现可以通过外部容器注入 用户记录用户登录的连续错误次数
	 */
	private Cache<String, AtomicInteger> passwordRetryCache;
	/**
	 * 用户登录的连续最大错误次数
	 */
	private Integer excessiveCount;
	
	public Integer getExcessiveCount() {
		return excessiveCount;
	}

	public void setExcessiveCount(Integer excessiveCount) {
		this.excessiveCount = excessiveCount;
	}
	
	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	/**
	 * 认证（密码比对） 在这里用户输入的密码会在doCredentialsMatch方法中获取info传入的盐值进行hash，
	 * 所以需要在shiroDbRealm中传入盐值
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		String username = (String) token.getPrincipal();// 从登陆凭证中获取用户名
		AtomicInteger retryCount = passwordRetryCache.get(username);// 查看当前缓存中改用户是否有登陆错误记录
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		// 自定义一个验证过程：当用户连续输入密码错误5次以上禁止用户登录一段时间,登录错误次数超限直接抛出异常
		if (retryCount.incrementAndGet() > excessiveCount) {
			log.info("用户密码错误次数超过"+excessiveCount+"次");
			throw new ExcessiveAttemptsException();// 错误次数过多
		}
		// System.out.println(((SaltedAuthenticationInfo)
		// info).getCredentialsSalt());
		// 使用父类的验证方法
		boolean match = super.doCredentialsMatch(token, info);
		if (match) {
			passwordRetryCache.remove(username);
		}
		return match;
	}

}

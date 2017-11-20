package com.core.shiro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busi.domain.Role;
import com.busi.domain.RoleExample;
import com.busi.domain.User;
import com.busi.domain.UserRoleKey;
import com.busi.mapper.RoleMapper;
import com.core.shiro.service.RoleService;
import com.core.shiro.service.UserService;

@Service
public class RoleServiceImpl implements RoleService{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UserService userService;
	
	public List<Role> findAll() {
		return roleMapper.selectByExample(new RoleExample());
	}

	public List<Role> findByUserName(String userName) {
		log.info("根据用户名["+userName+"]查找角色");
		
		User user = userService.getUserByUserName(userName);
		List<UserRoleKey> userRoleKeys = userRoleService.findByUserId(user.getId());
		
		List<Role> roles = new ArrayList<Role>();
		for(UserRoleKey key : userRoleKeys){
			roles.add(roleMapper.selectByPrimaryKey(key.getRoleId()));
		}
		return roles;
	}
	
}

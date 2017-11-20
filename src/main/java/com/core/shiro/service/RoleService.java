package com.core.shiro.service;

import java.util.List;

import com.busi.domain.Role;

public interface RoleService {
	public List<Role> findAll();
	public List<Role> findByUserName(String userName);
}

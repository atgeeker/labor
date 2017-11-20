package com.core.shiro.service.impl;

import java.util.List;

import com.busi.domain.UserRoleKey;

public interface UserRoleService {
	public List<UserRoleKey> findAll();
	public List<UserRoleKey> findByUserId(Long userId);
}

package com.core.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busi.domain.UserRoleExample;
import com.busi.domain.UserRoleExample.Criteria;
import com.busi.domain.UserRoleKey;
import com.busi.mapper.UserRoleMapper;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;
	public List<UserRoleKey> findAll() {
		
		return userRoleMapper.selectByExample(new UserRoleExample());
	}

	public List<UserRoleKey> findByUserId(Long userId) {
		UserRoleExample example = new UserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return userRoleMapper.selectByExample(example);
	}

}

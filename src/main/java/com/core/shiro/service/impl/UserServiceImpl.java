package com.core.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.busi.domain.User;
import com.busi.domain.UserExample;
import com.busi.domain.UserExample.Criteria;
import com.busi.mapper.UserMapper;
import com.core.shiro.service.UserService;

@Repository("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByUserName(String userName){
		
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		
		//通过用户名从数据库中读取到相应的用户  
		List<User> list = userMapper.selectByExample(example);
		if(list.size() == 0){
			return null;
		}
	    User user = userMapper.selectByExample(example).get(0);
		return user;
	}
	
}

package com.fs.mapper;

import com.fs.entity.User;

public interface UserMapper {
	
	public int addSelective(User user);
	
	public User findByPhone(String phone);
}

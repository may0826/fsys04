package com.fs.service;

import com.fs.entity.User;

public interface UserService {
	
	public boolean addUser(User u);
	
	public boolean modifyUser(User u);
	
	public User findByPhone(String phone, String password);
	
}

package com.fs.serviceImpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.entity.User;
import com.fs.mapper.UserMapper;
import com.fs.service.UserService;

@Service("userservice")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper mapper;

	@Override
	public boolean addUser(User u) {
		
		u.setRegtime(new Date());
		// 调用 佣人
		if(this.mapper.addSelective(u) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyUser(User u) {
		return false;
	}

	@Override
	public User findByPhone(String phone, String password) {
		User u = this.mapper.findByPhone(phone);
		
		if(u != null) {
			// 找到了 但是要继续判断密码
			if(u.getPcode().equals(password)) {
				//  合法的
				return u;
			}else {
				// 密码不正确
			}
		}
		return null;
	}

}

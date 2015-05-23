package com.pmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmp.common.DateUtil;
import com.pmp.dao.jdbc.UserDao;
import com.pmp.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void add(User user) {
		user.setLastdate(DateUtil.getNowDateTime());
		userDao.save(user);
	}

	public User findUser(User user) {
		return userDao.findUniqueResult(user);
	}
	
	public User findUserByEmail(User user){
		return userDao.findUniqueResult(user);
	}

	public User testLogin(User user) {
		return findUserByEmail(user);
		
	}
}

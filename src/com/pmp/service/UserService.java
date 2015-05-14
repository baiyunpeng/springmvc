package com.pmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmp.dao.UserDao;
import com.pmp.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void add(User user) {
		userDao.save(user);
	}

	public User findUser(User user) {
		return userDao.findUser(user);
	}
}

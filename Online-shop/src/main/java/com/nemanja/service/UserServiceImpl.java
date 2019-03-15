package com.nemanja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.dao.UserDao;
import com.nemanja.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;

	@Override
	public List<User> findAll() {
		return userdao.findAll();
	}

	@Override
	public void saveUser(User user) {
		userdao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}


	@Override
	public User findById(int id) {
		return userdao.findById(id);
	}

	
}

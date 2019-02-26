package com.nemanja.service;

import java.util.List;

import com.nemanja.entity.User;

public interface UserService {
	public List<User> findAll();

	public void saveUser(User user);
}

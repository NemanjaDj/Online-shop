package com.nemanja.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.dao.UserDao;
import com.nemanja.dao.UserRoleDao;
import com.nemanja.entity.User;
import com.nemanja.entity.UserRole;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public List<User> findAll() {
		return userdao.findAll();
	}

	@Override
	public void saveUser(User user) {
		UserRole userrole = new UserRole(user, "ROLE_USER");
		Set<UserRole> roles = user.getUserRole();
		roles.add(userrole);
		user.setUserRole(roles);
		userdao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}
	
}

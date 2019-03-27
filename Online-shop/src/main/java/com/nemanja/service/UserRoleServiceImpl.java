package com.nemanja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.dao.UserRoleDao;
import com.nemanja.entity.User;
import com.nemanja.entity.UserRole;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired 
	private UserRoleDao userRoleDao;
	
	public void saveRole(UserRole userRole) {
		userRoleDao.save(userRole);
	}

	@Override
	public void removeUserRole(User user) {
		userRoleDao.removeUserRole(user);
	}
}

package com.nemanja.service;

import com.nemanja.entity.User;
import com.nemanja.entity.UserRole;

public interface UserRoleService {
	public void saveRole(UserRole userRole);

	public void removeUserRole(User user);
}

package com.nemanja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nemanja.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	public List<User> findAll();
	User findByUsername(String username);
	@Query("SELECT r.userRole FROM UserRole r WHERE r.user.getUsername()= :username")
	public List<String> findUserRoleByUsername(String username);
}

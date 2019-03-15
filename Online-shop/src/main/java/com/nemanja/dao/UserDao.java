package com.nemanja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nemanja.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public List<User> findAll();
	
	public User findByUsername(String username);
	
	public User findById(int id);
	
	@Query("SELECT r.userRole FROM UserRole r WHERE r.user.getUsername()= :username")
	public List<String> findUserRoleByUsername(@Param("username")String username);
}

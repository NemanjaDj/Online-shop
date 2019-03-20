package com.nemanja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nemanja.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	public List<User> findAll();
	
	public User findByUsername(String username);
	
	@Query("SELECT u.password FROM User u WHERE u.username=:username")
	public String getPassword(@Param("username")String username);

}

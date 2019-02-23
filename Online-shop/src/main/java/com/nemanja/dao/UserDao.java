package com.nemanja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nemanja.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	public List<User> findAll();
}

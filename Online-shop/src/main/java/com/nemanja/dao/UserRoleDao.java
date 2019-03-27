package com.nemanja.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nemanja.entity.User;
import com.nemanja.entity.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer>{
	
	@Transactional
	@Modifying
	@Query("DELETE FROM UserRole u WHERE u.user=:user")
	public void removeUserRole(@Param("user") User user);
	
	public UserRole findByUser(User user);
}

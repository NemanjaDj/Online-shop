package com.nemanja.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nemanja.entity.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer>{

}

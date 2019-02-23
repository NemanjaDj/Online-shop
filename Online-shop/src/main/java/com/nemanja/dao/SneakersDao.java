package com.nemanja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nemanja.entity.Sneakers;

public interface SneakersDao extends JpaRepository<Sneakers, Integer>{
	public List<Sneakers> findAll();
	
}

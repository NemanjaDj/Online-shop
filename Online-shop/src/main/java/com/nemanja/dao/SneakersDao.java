package com.nemanja.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nemanja.entity.Sneakers;

public interface SneakersDao extends JpaRepository<Sneakers, Integer>{
	public List<Sneakers> findAll();
	
	@Query("SELECT s FROM Sneakers s WHERE LOWER(s.name) = LOWER(:freeText)")
    public List<Sneakers> SearchByName(@Param("freeText") String freeText);
	
	@Query("SELECT s FROM Sneakers s WHERE LOWER(s.brand) = LOWER(:brand) AND LOWER(s.type) = LOWER(:type)")
	public List<Sneakers> filterSearch(@Param("brand") String brand,@Param("type") String type);
	
	@Query("SELECT s FROM Sneakers s WHERE LOWER(s.brand) = LOWER(:brand)")
	public List<Sneakers> filterBrand(@Param("brand") String brand);
	
	@Query("SELECT s FROM Sneakers s WHERE LOWER(s.type) = LOWER(:type)")
	public List<Sneakers> filterType(@Param("type") String type);
}

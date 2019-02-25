package com.nemanja.service;

import java.util.List;

import com.nemanja.entity.Sneakers;


public interface SneakersService {
	public List<Sneakers> getSneakers();
	
	public List<Sneakers> SearchByName(String freeText);
	//public List<Sneakers> filterSneakers(String brand, String type);

	public Object filterSearch(String brand, String type);
}

package com.nemanja.service;

import java.util.List;

import com.nemanja.entity.Sneakers;


public interface SneakersService {
	public List<Sneakers> getSneakers();
	
	public Sneakers findByName(String name);
	
	public List<Sneakers> SearchByName(String freeText);

	public List<Sneakers> filterSearch(String brand, String type, String price);

	public void addSneakers(Sneakers newSneakers);
}

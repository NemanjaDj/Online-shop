package com.nemanja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.dao.SneakersDao;
import com.nemanja.entity.Sneakers;

@Service("SneakersService")
public class SneakersServiceImpl implements SneakersService {

	@Autowired
	private SneakersDao sneakersDao;
	
	@Override
	public List<Sneakers> getSneakers() {
		return sneakersDao.findAll();
	}

	@Override
	public List<Sneakers> SearchByName(String freeText) {
		return sneakersDao.SearchByName(freeText);
	}

	@Override
	public Object filterSearch(String brand, String type) {
		return sneakersDao.filterSearch(brand, type);
	}
	
	
	/*
	@Override
	public List<Sneakers> filterSneakers(String brand, String type) {
		return sneakersDao.filterSneakers(brand, type);
	}
	*/
}

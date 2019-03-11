package com.nemanja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
		freeText=freeText.replaceAll("\\s+","");
		if(freeText.equals(""))
			return sneakersDao.findAll();
		return sneakersDao.SearchByName(freeText);
	}

	@Override
	public List<Sneakers> filterSearch(String brand, String type, String price) {
		if(brand.equals("all")) {
			if(type.equals("all"))
				return sneakersDao.filterPrice(price);
			else
				return sneakersDao.filterType(type, price);
		} if(type.equals("all"))
			return sneakersDao.filterBrand(brand, price);
			
		return sneakersDao.filterSearch(brand, type, price);
	}

	@Override
	public void addSneakers(Sneakers newSneakers) {
		sneakersDao.save(newSneakers);
		
	}

}

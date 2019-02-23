package com.nemanja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.dao.SneakersDao;
import com.nemanja.entity.Sneakers;

@Service
public class SneakersServiceImpl implements SneakersService {

	@Autowired
	private SneakersDao sneakersDao;
	
	@Override
	public List<Sneakers> getSneakers() {
		return sneakersDao.findAll();
	}

}

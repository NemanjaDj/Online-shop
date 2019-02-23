package com.nemanja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nemanja.entity.Sneakers;
import com.nemanja.service.SneakersService;

@Controller
@RequestMapping("/sneakers")
public class SneakersController {
	
	@Autowired
	private SneakersService sneakersService;

	@GetMapping("/")
	public String showSneakers(Model theModel) {
		
		List<Sneakers> sneakers = sneakersService.getSneakers();
		
		theModel.addAttribute("sneakers", sneakers);
		
		return "list-sneakers";
	}
	
	
}

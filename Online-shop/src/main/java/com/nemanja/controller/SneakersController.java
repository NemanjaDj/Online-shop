package com.nemanja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/sneakers_search")
	public String sneakersSearch(Model m, @RequestParam("freeText") String freeText) {
		m.addAttribute("sneakers", sneakersService.SearchByName(freeText));
		return "list-sneakers";
	}
	
	@GetMapping("/filterSearch")
	public String filterSneakers(Model theModel,@RequestParam("brand") String brand, @RequestParam("type") String type) {
		
		theModel.addAttribute("sneakers", sneakersService.filterSearch(brand, type));
		
		return "list-sneakers";
	}
	
	@PostMapping("/addSneakers")
	public String addSneakers(@ModelAttribute("newSneakers") Sneakers newSneakers) {
		sneakersService.addSneakers(newSneakers);
		return "redirect:/sneakers/";
	}

	@GetMapping("/addSneakers")
	public String newSneakersForm() {
		return "add-sneakers";
	}
	
}


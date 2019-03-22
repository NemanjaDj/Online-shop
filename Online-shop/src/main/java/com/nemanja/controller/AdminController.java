package com.nemanja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nemanja.entity.Sneakers;
import com.nemanja.service.SneakersService;

@Controller
@RequestMapping("/adminRoom")
public class AdminController {
	
	@Autowired
	private SneakersService sneakersService;
	
	@PostMapping("/addSneakers")
	public String addSneakers(@ModelAttribute("newSneakers") Sneakers newSneakers) {
		sneakersService.addSneakers(newSneakers);
		return "redirect:/adminRoom";
	}
	
	@GetMapping("/addSneakers")
	public String newSneakersForm(Model themodel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		themodel.addAttribute("username", name);
		return "add-sneakers";
	}
	
	@GetMapping("/")
	public String showAdminRoom(Model themodel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		themodel.addAttribute("username", name);
		return "adminRoom";
	}
}

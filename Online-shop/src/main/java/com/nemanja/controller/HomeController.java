package com.nemanja.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nemanja.entity.Sneakers;
import com.nemanja.entity.User;
import com.nemanja.service.SneakersService;
import com.nemanja.service.UserService;

@Controller
@SessionAttributes("name")
public class HomeController {

	@Autowired
	private SneakersService sneakersService;

	@Autowired
	private UserService userservice;

	@GetMapping("/")
	public String welcomePage(Model themodel) {

		themodel.addAttribute("username", loggedUsername());
		return "welcome";
	}

	// List of user's cart items
	@GetMapping("/userpage")
	public String userPage(Model themodel) {

		themodel.addAttribute("username", loggedUsername());

		User user = userservice.findByUsername(loggedUsername().toLowerCase());
		Set<Sneakers> usersneakers = user.getSneakers();
		themodel.addAttribute("usercardsneakers", usersneakers);
		themodel.addAttribute("sumItems", userservice.sumCartItems(loggedUsername()));
		themodel.addAttribute("userCredit", user.getCredit()); 
		return "user-page";
	}

	@PostMapping("/userpage")
	public String orderSneakers() {
		
		userservice.buySneakers(loggedUsername());
		
		return "redirect:/userpage";
	}
	
	@GetMapping("/removeUserSneakers")
	public String removeFromList(@RequestParam String name) {	
		Sneakers sneakers = sneakersService.findByName(name);
		userservice.removeUserSneakersFromCart(loggedUsername(), sneakers);
		
		return "redirect:/userpage";
	}

	// return logged in username
	
	public String loggedUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username
		return username;
	}

}

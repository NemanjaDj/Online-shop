package com.nemanja.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		themodel.addAttribute("username", name);
		return "welcome";
	}

	// List of user's cart items
	@GetMapping("/userpage")
	public String userPage(Model themodel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		themodel.addAttribute("username", name);
		User user = userservice.findByUsername(name.toLowerCase());
		Set<Sneakers> usersneakers = user.getSneakers();
		themodel.addAttribute("usercardsneakers", usersneakers);
		return "user-page";
	}

	@PostMapping("/userpage")
	public String removeFromlist(@RequestParam("sneakersname") String sneakersname) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username
		User user = userservice.findByUsername(username.toLowerCase());
		Sneakers tike = sneakersService.findByName(sneakersname);
		Set<Sneakers> sneakers = user.getSneakers();
		sneakers.remove(tike);
		user.setSneakers(sneakers);
		userservice.saveUser(user);
		return "redirect:/userpage";
	}

}

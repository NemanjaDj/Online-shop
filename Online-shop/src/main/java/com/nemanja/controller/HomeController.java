package com.nemanja.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HomeController {

	@GetMapping("/")
	public String welcomePage(Model themodel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		themodel.addAttribute("username", name);
		return "welcome";
	}

	@GetMapping("/userpage")
	public String userPage(Model themodel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		
		themodel.addAttribute("username", name);
		
		return "user-page";
	}
}

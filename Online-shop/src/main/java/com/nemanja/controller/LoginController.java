package com.nemanja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nemanja.entity.User;
import com.nemanja.service.UserService;

@Controller
@RequestMapping("/login")

public class LoginController {
	
	@Autowired
	private UserService userService;
	
	//private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String logInPage(){
		
		return "login";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user){
		//BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		//String p = bCryptPasswordEncoder.encode(user.getPassword());
		//user.setPassword(p);
		userService.saveUser(user);
		return "redirect:/login/";
	}
	
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
}

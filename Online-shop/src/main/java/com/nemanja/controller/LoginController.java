package com.nemanja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@GetMapping("/")
	public String logInPage(){
		
		return "login";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return "registration";
        }
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String p = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(p);
		userService.saveUser(user);
		return "redirect:/login/";
	}
	
	
	@GetMapping("/registration")
	public String registration(Model model) {
		//we must include this modelAttribute to be able to see registration page
		model.addAttribute("user", new User());
		return "registration";
	}
}

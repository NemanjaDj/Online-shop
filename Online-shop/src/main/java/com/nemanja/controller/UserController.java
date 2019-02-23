package com.nemanja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nemanja.entity.User;
import com.nemanja.service.UserServiceImpl;

@RestController
@RequestMapping("/customer/")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/users")
	public List<User> welcome() {
		return userService.findAll();
	}

}

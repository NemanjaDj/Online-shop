package com.nemanja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nemanja.entity.Sneakers;
import com.nemanja.entity.User;
import com.nemanja.service.SneakersService;
import com.nemanja.service.UserRoleService;
import com.nemanja.service.UserService;

@Controller
@RequestMapping("/adminRoom")
public class AdminController {

	@Autowired
	private SneakersService sneakersService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@PostMapping("/addSneakers")
	public String addSneakers(@ModelAttribute("newSneakers") Sneakers newSneakers, BindingResult result) {
		if (result.hasErrors()) {
			return "add-sneakers";
		}
		sneakersService.addSneakers(newSneakers);
		return "redirect:/adminRoom/";
	}

	@GetMapping("/addSneakers")
	public String newSneakersForm(Model themodel) {

		themodel.addAttribute("newSneakers", new Sneakers());
		return "add-sneakers";
	}

	@GetMapping("/")
	public String showAdminRoom(Model themodel) {
		return "adminRoom";
	}

	@GetMapping("/listOfUsers")
	public String listOfUsers(Model model) {

		List<User> users = userService.findAll();
		model.addAttribute("userlist", users);
		return "user-list";
	}

	@PostMapping("/listOfUsers")
	public String updateUserCredit(@RequestParam("credit") int credit, @RequestParam("user") String username ) {
		
		userService.updateUserCredit(credit, username);
		
		return "redirect:/adminRoom/listOfUsers";
	}
	
	@GetMapping("/removeUser")
	public String removeUser(@RequestParam("username") String username) {
		userRoleService.removeUserRole(userService.findByUsername(username));
		userService.removeUser(username);
		return "redirect:/adminRoom/listOfUsers";
	}
	
}

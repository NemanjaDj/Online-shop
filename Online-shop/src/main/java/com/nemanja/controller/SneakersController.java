package com.nemanja.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nemanja.entity.Sneakers;
import com.nemanja.entity.User;
import com.nemanja.service.SneakersService;
import com.nemanja.service.UserService;

@Controller
@RequestMapping("/sneakers")
@SessionAttributes("name")
public class SneakersController {

	@Autowired
	private SneakersService sneakersService;

	@Autowired
	private UserService userservice;

	// list all sneakers from database
	@GetMapping("/")
	public String showSneakers(Model theModel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get logged in username

		List<Sneakers> sneakers = sneakersService.getSneakers();
		theModel.addAttribute("username", username);
		theModel.addAttribute("sneakers", sneakers);

		return "list-sneakers";
	}

	// user adds sneakers to cart 
	
	@RequestMapping(value="/", method=RequestMethod.POST, params={"sneakersname"})
	public String addToCart(@RequestParam("sneakersname") String sneakersname) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		
			User user = userservice.findByUsername(name.toLowerCase());
			Sneakers tempsneakers = sneakersService.findByName(sneakersname);
			Set<Sneakers> userSneakers = user.getSneakers();
			userSneakers.add(tempsneakers);
			user.setSneakers(userSneakers);
			userservice.saveUser(user);
		return "redirect:/sneakers/";
	}

	@GetMapping("/sneakers_search")
	public String sneakersSearch(Model m, @RequestParam("freeText") String freeText) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		m.addAttribute("username", name);

		m.addAttribute("sneakers", sneakersService.SearchByName(freeText));
		return "list-sneakers";
	}

	@GetMapping("/filterSearch")
	public String filterSneakers(Model theModel, @RequestParam("brand") String brand, @RequestParam("type") String type,
			@RequestParam("price") String price) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		theModel.addAttribute("username", name);

		theModel.addAttribute("sneakers", sneakersService.filterSearch(brand, type, price));

		return "list-sneakers";
	}

	@PostMapping("/addSneakers")
	public String addSneakers(@ModelAttribute("newSneakers") Sneakers newSneakers) {
		sneakersService.addSneakers(newSneakers);
		return "redirect:/sneakers/";
	}

	@GetMapping("/addSneakers")
	public String newSneakersForm(Model themodel) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username

		themodel.addAttribute("username", name);
		return "add-sneakers";
	}

}

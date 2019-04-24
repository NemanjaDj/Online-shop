package com.nemanja.service;

import java.util.List;

import com.nemanja.entity.Sneakers;
import com.nemanja.entity.User;

public interface UserService {
	public List<User> findAll();
	
	public User findByUsername(String username);
	
	public void saveUser(User user);
	
	public void removeUser(String username);
	
	public int sumCartItems(String username);
	
	public void buySneakers(String username);
	
	public void removeUserSneakersFromCart(String username, Sneakers sneakers);

	public void updateUserCredit(int credit, String username);
}

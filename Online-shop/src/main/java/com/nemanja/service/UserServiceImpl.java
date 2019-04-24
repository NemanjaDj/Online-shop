package com.nemanja.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemanja.dao.UserDao;
import com.nemanja.dao.UserRoleDao;
import com.nemanja.entity.Sneakers;
import com.nemanja.entity.User;
import com.nemanja.entity.UserRole;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public List<User> findAll() {
		return userdao.findAll();
	}

	@Override
	public void saveUser(User user) {
		if(userRoleDao.findByUser(user)== null) {
		UserRole userrole = new UserRole(user, "ROLE_USER");
		Set<UserRole> roles = user.getUserRole();
		roles.add(userrole);
		user.setUserRole(roles);
		}
		userdao.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return userdao.findByUsername(username);
	}

	@Override
	public void removeUser(String username) {
		userdao.removeUser(username);
	}

	@Override
	public int sumCartItems(String username) {
		User user = userdao.findByUsername(username);
		int sum = 0;
		Set<Sneakers> userSneakers = user.getSneakers();
		
		for(Sneakers i: userSneakers) {
			sum += i.getPrice();
		}
		return sum;
	}

	// when user order some sneakers, credit is updated 
	// and sneakers are removed from cart.
	
	@Override
	public void buySneakers(String username) {
		User user = userdao.findByUsername(username);
		try {
		int remainingCredit = user.getCredit()-sumCartItems(username);
		if(remainingCredit >= 0) {
		userdao.updateUserCredit(remainingCredit, username);
		// removing ordered sneakers from cart
		user.setSneakers(null);
		saveUser(user);
		}
		else throw new IllegalArgumentException(); 
		}catch( IllegalArgumentException e) {
			System.out.println("unfortunately, you don't have enough credit for purchase.");
		}
	}
	
	@Override
	public void removeUserSneakersFromCart(String username, Sneakers sneakers) {
		User user = findByUsername(username.toLowerCase());
		Set<Sneakers> userSneakers = user.getSneakers();
		userSneakers.remove(sneakers);
		user.setSneakers(userSneakers);
		saveUser(user);
	}

	// add credit to user
	
	@Override
	public void updateUserCredit(int credit, String username) {
		User user = findByUsername(username.toLowerCase());
		user.setCredit(user.getCredit()+credit);
		userdao.updateUserCredit(user.getCredit(), username);
	}
	
}

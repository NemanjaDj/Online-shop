package com.nemanja.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "username", length = 45)
	@Size(min = 4, max = 16, message = "username size must be between 4 and 16")
	private String username;
	@Column(name = "email", length = 45)
	@NotEmpty(message = "Please enter email")
	private String email;
	@Column(name = "password", length = 120)
	@Size(min = 4, max = 60, message = "password size must be between 4 and 16")
	private String password;
	@Column(name="credit")
	private int credit = 300;
	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<>();

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "user_cart", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = {
			@JoinColumn(name = "sneakersid") })
	Set<Sneakers> sneakers = new HashSet<>();

	// Constructors

	public User() {
	}

	public User(String name, String email, String password) {
		this.username = name;
		this.email = email;
		this.password = password;
	}

	// Getters & Setters

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public Set<Sneakers> getSneakers() {
		return sneakers;
	}

	public void setSneakers(Set<Sneakers> sneakers) {
		this.sneakers = sneakers;
	}

	// toString method

	@Override
	public String toString() {
		return "User [ name=" + username + ", email=" + email + ", password=" + password + "]";
	}
}

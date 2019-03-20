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

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "username", length = 45)
	private String username;
	@Column(name = "email", length = 45)
	private String email;
	@Column(name = "password", length = 120)
	private String password;
	@Column(name = "enabled")
	private boolean enabled;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<>();

	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "user_cart", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = {
			@JoinColumn(name = "sneakersid") })
	Set<Sneakers> sneakers = new HashSet<>();

	// Constructors

	public User() {}

	public User(String username, String email, String password, Set<UserRole> userRole) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = true;
		this.userRole = userRole;
	}
	public User(String username, String password, Set<Sneakers> sneakers, String email) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = true;
		this.sneakers = sneakers;
	}
	
	public User(String username, String password, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = true;
		this.userRole = userRole;
	}

	public User(String name, String email, String password) {
		this.username = name;
		this.email = email;
		this.password = password;
		this.enabled = true;
	}

	// Getters & Setters

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


	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

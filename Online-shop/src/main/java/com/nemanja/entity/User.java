package com.nemanja.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="username",length=45)
	private String username;
	@Column(name="email",length=45)
	private String email;
	@Column(name="password",length=120)
	private String password;
	@Column(name="enabled")
	private boolean enabled;
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<>();
	
	//Constructors
	
	public User() {}
	
	public User(String name, String email, String password, boolean enabled) {
		this.username = name;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String email, String password, boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}
	
	public User(String name, String email, String password) {
		this.username = name;
		this.email = email;
		this.password = password;
		this.enabled = true;
		this.userRole.add(new UserRole
				(new User(this.username,this.email,this.password, true), "user"));
	}

	//Getters & Setters

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	// toString method

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", email=" + email + ", password=" + password + "]";
	}

	
	
}

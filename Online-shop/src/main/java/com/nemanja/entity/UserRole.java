package com.nemanja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleid;
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	@Column(name="userrole",length=45)
	private String userRole;
	
	//Constructors
	
	public UserRole() {}
	
	public UserRole(User user,String userRole) {
		this.userRole = userRole;
		this.user = user;
	}

	// Getters & Setters methods
	
	public User getUserid() {
		return user;
	}

	public void setUserid(User user) {
		this.user = user;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	//ToString method

	@Override
	public String toString() {
		return "UserRole [user=" + user + ", userRole=" + userRole + "]";
	}
	
}

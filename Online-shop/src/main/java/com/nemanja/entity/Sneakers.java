package com.nemanja.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="sneakers")
public class Sneakers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="brand",length=45)
	private String brand;
	@Column(name="name",length=45)
	private String name;
	@Column(name="type",length=45)
	private String type;
	private int price;
	
	@ManyToMany(mappedBy = "sneakers",
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    private Set<User> users = new HashSet<>();
	
	//Constructors
	
	

	public Sneakers() {}

	public Sneakers(String brand, String name, String type, int price) {
		this.brand = brand;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	//Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
		
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	// toString method

	@Override
	public String toString() {
		return "Sneakers [id=" + id + ", brand=" + brand + ", name=" + name + ", type=" + type + ", price=" + price
				+ "]";
	}
}

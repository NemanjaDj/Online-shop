package com.nemanja.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sneakers")
public class Sneakers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String name;
	private String type;
	private int price;
	
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

	// toString method
		
	@Override
	public String toString() {
		return "Sneakers [id=" + id + ", brand=" + brand + ", name=" + name + ", type=" + type + ", price=" + price
				+ "]";
	}
}

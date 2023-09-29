package com.FruitMangementSystem.SpringBootCURDwithdatabase.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Fruit {

	@Id
	int id;
	String fruit;
	String price;
	
	
	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Fruit [id=" + id + ", fruit=" + fruit + ", price=" + price + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFruit() {
		return fruit;
	}


	public void setFruit(String fruit) {
		this.fruit = fruit;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Fruit(int id, String fruit, String price) {
		super();
		this.id = id;
		this.fruit = fruit;
		this.price = price;
	}
		
	
}

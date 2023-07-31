package com.furnitureapp.model;

import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection="furniture")
public class Furniture {
	
	private String name;
	@Field(name = "cost")
	private double price;
	private String upholstery;
	@Id
	private Integer seater;
	private String colour;
	

	
	public Furniture(String name, double price, String upholstery, Integer seater, String colour) {
		super();
		this.name = name;
		this.price = price;
		this.upholstery = upholstery;
		this.seater = seater;
		this.colour = colour;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUpholstery() {
		return upholstery;
	}
	public void setUpholstery(String upholstery) {
		this.upholstery = upholstery;
	}
	public Integer getSeater() {
		return seater;
	}
	public void setSeater(Integer seater) {
		this.seater = seater;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Furniture() {
		super();
		
	}
	@Override
	public String toString() {
		return "Furniture [name=" + name + ", price=" + price + ", upholstery=" + upholstery + ", seater=" + seater
				+ ", colour=" + colour + "]";
	}

	
}

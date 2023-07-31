package com.furnitureapp.model;

public class FurnitureDTO {
	private String name;
	private double price;
	private String upholstery;
	private Integer seater;
	private String colour;
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
	public FurnitureDTO() {
		super();
		
	}
	public FurnitureDTO(String name, double price, String upholstery, Integer seater, String colour) {
		super();
		this.name = name;
		this.price = price;
		this.upholstery = upholstery;
		this.seater = seater;
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "FurnitureDTO [name=" + name + ", price=" + price + ", upholstery=" + upholstery + ", seater=" + seater
				+ ", colour=" + colour + "]";
	}
	
}

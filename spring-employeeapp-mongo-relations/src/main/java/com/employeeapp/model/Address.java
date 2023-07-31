package com.employeeapp.model;

import lombok.AllArgsConstructor;


import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.ToString;

 

@Setter

@Getter

@NoArgsConstructor

@AllArgsConstructor

@ToString

public class Address {
	private String city;
    private String state;
    private long zipcode;
    public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public Address(String city, String state, long zipcode) {
		super();
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	

} 
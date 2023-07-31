package com.kloudspot.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Address {
	 private String city;
	 private String state;
	 private Address address;
	 private Double salary;
	public Double getSalary() {
		return salary;
	}
	@Value("1200000")
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	@Value("JO")
	public void setCity(String city) {
		this.city = city;
	}
	@Value("Bangalore")
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	@Value("Karnataka")
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
}

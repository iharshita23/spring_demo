package com.kloud.setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Address {
	 private String city;
	 private String state;
	 private Address address;

	public void setAddress(Address address) {
		this.address = address;
	}

	@Value("${employee.address.city}")
	public void setCity(String city) {
		this.city = city;
	}
	@Value("${employee.address.state}")
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
}

package com.employeeapp.model;

import java.util.List;



import org.springframework.data.mongodb.core.mapping.DBRef;

import org.springframework.data.mongodb.core.mapping.Document;

 

@Document(collection="newemployee")

public class Employee {

    private String name;

    private Integer employeeID;

    private String designation;

    private Address address;

    private String[] hobbies;
    

    public Employee(String name, Integer employeeID, String designation, Address address, String[] hobbies,
			List<Benefits> benefits) {
		super();
		this.name = name;
		this.employeeID = employeeID;
		this.designation = designation;
		this.address = address;
		this.hobbies = hobbies;
		this.benefits = benefits;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String[] getHobbies() {
		return hobbies;
	}


	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}


	public List<Benefits> getBenefits() {
		return benefits;
	}


	public void setBenefits(List<Benefits> benefits) {
		this.benefits = benefits;
	}


	private List<Benefits> benefits;

}
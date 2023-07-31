package com.springshape;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.autowiring.ShapeFactory;
import com.kloud.setter.Employee;

@SpringBootApplication(scanBasePackages = {"com.kloud","com.example"})
public class SpringShapeApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringShapeApplication.class, args);
	}
	
	private Employee employee;
	private ShapeFactory shapeFactory;
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Autowired
	public void setShapeFactory(ShapeFactory shapefactory) {
		this.shapeFactory = shapefactory;
	}
	public void run(String...args) throws Exception{
		System.out.println(employee);
		System.out.println(shapeFactory);
	}

}
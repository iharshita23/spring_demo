package com.kloud.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	private String name;
	private double salary;
	public String getName() {
		return name;
	}
	@Value("${employee.name}")
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	@Value("${employee.salary}")
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
}

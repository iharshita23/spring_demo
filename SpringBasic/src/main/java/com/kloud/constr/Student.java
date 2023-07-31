package com.kloud.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Student {
	private String name;
	private Double studentId;
	private Department department;
	public Student( Department department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}
	public Double getStudentId() {
		return studentId;
	}
	@Value("${student.studentId}")
	public void setStudentId(Double studentId) {
		this.studentId = studentId;
	}
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + ", department=" + department + "]";
	}
}

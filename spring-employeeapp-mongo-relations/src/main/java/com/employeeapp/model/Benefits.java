package com.employeeapp.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 

import lombok.AllArgsConstructor;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.ToString;

 

@Document

@Setter

@Getter

@NoArgsConstructor

@AllArgsConstructor

@ToString

public class Benefits {

    private String benefitName;
    @Id
    private Integer benefitId;

	private Category category; // enum

    private String grade;

    private LocalDate issueDate;
    
    public Benefits(String benefitName, Integer benefitId, Category category, String grade, LocalDate issueDate) {
		super();
		this.benefitName = benefitName;
		this.benefitId = benefitId;
		this.category = category;
		this.grade = grade;
		this.issueDate = issueDate;
	}

}
package com.employeeapp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.Address;
import com.employeeapp.model.Benefits;
import com.employeeapp.model.Category;
import com.employeeapp.model.Employee;
import com.employeeapp.model.Grade;
import com.employeeapp.service.IBenefitService;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringEmployeeappMongoRelationsApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(SpringEmployeeappMongoRelationsApplication.class, args);
	}
	
	@Autowired
	IEmployeeService employeeService;

	@Autowired
    IBenefitService benefitService;
    
    public void run(String... args) throws Exception {
        Benefits carBenefit = new Benefits("Honda Car",21,Category.VEHICLE,Grade.DIRECTOR.getGradeNAme(),LocalDate.of(2023, 02, 01));
        benefitService.addBenefits(carBenefit);
        
        Benefits gadgetBenefit = new Benefits("Apple Pad",22,Category.GADGETS,Grade.DIRECTOR.getGradeNAme(),LocalDate.of(2023, 02,01));
        benefitService.addBenefits(gadgetBenefit);
    	
        List<Benefits> benefits = Arrays.asList(carBenefit,gadgetBenefit);
        benefits.add(carBenefit);
        benefits.add(gadgetBenefit);
        
        Address address = new Address("Bangalore","Karnataka",560048);
        String[] hobbies = {"Drawing","Dancing"};
        
    	Employee employees = new Employee("Harshita",101,"Director",address,hobbies,benefits);  
    	employeeService.addEmployee(employees);
    }

}

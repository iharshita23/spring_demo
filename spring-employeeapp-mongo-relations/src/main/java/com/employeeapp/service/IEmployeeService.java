package com.employeeapp.service;

import java.util.List;

import com.employeeapp.exceptions.EmployeeNotFoundException;

import java.util.List;



import com.employeeapp.exceptions.BenefitsNotFoundException;

import com.employeeapp.exceptions.EmployeeNotFoundException;

import com.employeeapp.exceptions.IdNotFoundException;

import com.employeeapp.model.Employee;

 

public interface IEmployeeService{

 

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee getById(int empId) throws IdNotFoundException;

    List<Employee> getAll();

    

    // Derived

    List<Employee> getByDesignation(String designation) throws EmployeeNotFoundException;

    List<Employee> getByDepartment(String department) throws EmployeeNotFoundException;

    List<Employee> getByCity(String city) throws EmployeeNotFoundException;

    

    //custom

    List<Employee> getByState(String state) throws EmployeeNotFoundException;

    List<Employee> getByBenefitName(String benefitName) throws BenefitsNotFoundException;

    List<Employee> getByCategory(String category) throws BenefitsNotFoundException;

    List<Employee> getByGradeAndBenefitName(String grade, String benefitName) throws BenefitsNotFoundException;

 

    
    List<Employee> getByGradeAndCity(String grade,String city) throws EmployeeNotFoundException;

    List<Employee> getByHobbies(String hobby) throws EmployeeNotFoundException;

    List<Employee> getByDesignationAndCategory(String designation, String category) throws EmployeeNotFoundException;
    
}

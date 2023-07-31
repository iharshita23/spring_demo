package com.employeeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.exceptions.BenefitsNotFoundException;
import com.employeeapp.exceptions.EmployeeNotFoundException;
import com.employeeapp.exceptions.IdNotFoundException;
import com.employeeapp.model.Employee;
import com.employeeapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }  
    @Override
    public void addEmployee(Employee employee) {
        this.employeeRepository.addEmployee(employee);
    }
    @Override
    public void updateEmployee(Employee employee) {
        this.employeeRepository.updateEmployee(employee);
    }
    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteById(id);
    }
    @Override
    public Employee getById(int empId) throws IdNotFoundException {
        return this.employeeRepository.findById(empId).orElseThrow(()-> new IdNotFoundException("No Emp with ID :" + empId));
    }

 

    @Override

    public List<Employee> getAll() {

        return this.employeeRepository.findAll();

    }

 

    @Override

    public List<Employee> getByDesignation(String designation) throws EmployeeNotFoundException {

        List<Employee> employees = this.employeeRepository.findByDesignation(designation);

        if(employees.isEmpty()) throw new EmployeeNotFoundException("No Employee with designation : "+ designation);

        return employees;

    }

 

    @Override

    public List<Employee> getByDepartment(String department) throws EmployeeNotFoundException {

        List<Employee> employees = this.employeeRepository.findByDepartment(department);

        if(employees.isEmpty()) throw new EmployeeNotFoundException("No Employee with department: "+ department);

        return employees;

    }

 

    @Override

    public List<Employee> getByCity(String city) throws EmployeeNotFoundException {

        List<Employee> employees = this.employeeRepository.findByCity(city);

        if(employees.isEmpty()) throw new EmployeeNotFoundException("No Employee with City : "+ city);

        return employees;

    }

 

    @Override

    public List<Employee> getByState(String state) throws EmployeeNotFoundException {

        List<Employee> employees = this.employeeRepository.findByState(state);

        if(employees.isEmpty()) throw new EmployeeNotFoundException("No Employee with State : "+ state);

        return employees;

        

    }

 

    @Override

    public List<Employee> getByBenefitName(String benefitName) throws BenefitsNotFoundException {

        List<Employee> employees = this.employeeRepository.findByBenefitName(benefitName);

        if(employees.isEmpty()) throw new BenefitsNotFoundException("No Employee with benefitName : "+ benefitName);

        return employees;

        

    }

 

    @Override

    public List<Employee> getByCategory(String category) throws BenefitsNotFoundException {

        List<Employee> employees = this.employeeRepository.findByCategory(category);

        if(employees.isEmpty()) throw new BenefitsNotFoundException("No Employee with  category: "+ category);

        return employees;

    }

 

    @Override

    public List<Employee> getByGradeAndBenefitName(String grade, String benefitName) throws BenefitsNotFoundException {

        List<Employee> employees = this.employeeRepository.findByGradeAndBenefitName(grade, benefitName);

        if(employees.isEmpty()) throw new BenefitsNotFoundException("No Employee with  grade : "+ grade+" and benefitName: " +benefitName);

        return employees;

    }

 

    @Override

    public List<Employee> getByGradeAndCity(String grade, String city) throws EmployeeNotFoundException {

        List<Employee> employees = this.employeeRepository.findByGradeAndCity(grade, city);

        if(employees.isEmpty()) throw new EmployeeNotFoundException("No Employee with  grade : "+ grade+" and city : " +city);

        return employees;

    }

 

    @Override

    public List<Employee> getByHobbies(String hobby) throws EmployeeNotFoundException {

        List<Employee> employees = this.employeeRepository.findByHobbies(hobby);

        if(employees.isEmpty()) throw new EmployeeNotFoundException("No Employee with hobby : "+ hobby);

        return employees;

    }

 

    @Override

    public List<Employee> getByDesignationAndCategory(String designation, String category) throws EmployeeNotFoundException {

        List<Employee> employees = this.employeeRepository.findByDesignationAndCategory(designation, category);

        if(employees.isEmpty()) throw new EmployeeNotFoundException("No Employee with Designation : "+ designation +" and caterory : " +category );

        return employees;

    }

 
	
}

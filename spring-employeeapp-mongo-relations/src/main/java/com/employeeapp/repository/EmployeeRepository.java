package com.employeeapp.repository;

import java.util.List;

 

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

 

import com.employeeapp.exceptions.EmployeeNotFoundException;
import com.employeeapp.model.Employee;

 

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

    void addEmployee(com.employeeapp.model.Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee getById(int empId) throws EmployeeNotFoundException;

    List<Employee> getAll();

    

    // Derived

    List<Employee> findByDesignation(String designation) throws EmployeeNotFoundException;

    List<Employee> findByDepartment(String department) throws EmployeeNotFoundException;

    List<Employee> findByCity(String city) throws EmployeeNotFoundException;

    List<Employee> findByDesignationAndCategory(String designation, String category)throws EmployeeNotFoundException;
    

    //custom
    @Query("{'address.state': ?0}")

    List<Employee> findByState(String state);

    

    @Query("{'benifits.benifitName': ?0}")

    List<Employee> findByBenefitName(String benefitName);

    

    @Query("{'benifits.category': ?0}")

    List<Employee> findByCategory(String category);

 

    @Query("{$and: [{'benifits.grade': ?0},{'benifits.benifitName': ?1}]")

    List<Employee> findByGradeAndBenefitName(String grade, String benefitName);

    

    @Query("{$and: [{'benifits.grade': ?0},{'address.city': ?1}]")

    List<Employee> findByGradeAndCity(String grade,String city);

    

    @Query("{hobbies: ?0}")

    List<Employee> findByHobbies(String hobby);

 

    @Query("{$and: [{designation: ?0},{'benifits.category': ?1}]")

    List<Employee> findByDesignationAndCategory1(String designation, String category);

}
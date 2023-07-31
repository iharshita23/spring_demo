package com.employeeapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Benefits;

@Repository
public interface IBenefitsRepository extends MongoRepository<Benefits,Integer>{
	void addBenefits(Benefits benefits);
}


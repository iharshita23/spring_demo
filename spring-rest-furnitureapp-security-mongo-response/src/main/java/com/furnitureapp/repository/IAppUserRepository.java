package com.furnitureapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.furnitureapp.model.AppUser;

@Repository
public interface IAppUserRepository extends MongoRepository<AppUser, String>{

//	Furniture getBySeater(Integer seater);
	AppUser findByUsername(String username);
}

package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.AppUser;

@Repository
public interface IAppUserRepository extends MongoRepository<AppUser,Integer>{
 
		AppUser findByusername(String username);
		//Optional<AppUser> findByEmail(String email,String password);
}

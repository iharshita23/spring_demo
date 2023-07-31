package com.doctorapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.doctorapp.model.Doctor;
@Repository
public interface IDoctorRepository extends MongoRepository<Doctor,Integer>{
		 List<Doctor> findBySpeciality(String special);
		 List<Doctor> findByHospitalName(String hospitalName);
		 List<Doctor> findByExperience(int experience);
		 List<Doctor> findByFees(double fees);
		 List<Doctor> getById(int doctorId);
		 List<Doctor> findBySpecialityAndFees(String speciality, double fees);
		 
	    @Query("{$and:[{speciality:?0,fees:{$lte:?1}]}")
	    List<Doctor> getBySpecialityFees(String speciality,double fees);
	    @Query("{$and:[{hospitalName: ?0,speciality: ?1}]}")
	    List<Doctor> findByHospitalAndSpeciality(String hospitalName,String speciality);
	    @Query("{$or: [{speciality: ?0},{experience: ?1}]")
	    List<Doctor> findBySpecialityOrExp(String speciality, int exp);
	
		//custom query
		@Query("{fees:{$lte:?0}}")
		List<Doctor> getByFees(double fees);		
		
}

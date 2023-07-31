package com.doctorapp.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService{
	// CRUD opertaions from inbuilt methods
	
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int doctorId);
    List<Doctor> getById(int doctorId) throws DoctorNotFoundException;
    List<Doctor>  getAllDoctors();

    // derived queries written using properties
    List<Doctor>  getByFees(double fees) throws DoctorNotFoundException;
    List<Doctor>  getBySpeciality(String speciality) throws DoctorNotFoundException;
    List<Doctor>  getByExperience(int experience) throws DoctorNotFoundException;
    List<Doctor>  getByHospitalName(String hospitalName) throws DoctorNotFoundException;

    // custom queries
    List<Doctor>  getByHospitalAndSpeciality(String hospitalName, String speciality) throws DoctorNotFoundException;
    List<Doctor>  getBySpecialityAndFees(String speciality,double fees) throws DoctorNotFoundException;
    List<Doctor>  getBySpecialityOrExp(String speciality,int exp)throws DoctorNotFoundException;
}

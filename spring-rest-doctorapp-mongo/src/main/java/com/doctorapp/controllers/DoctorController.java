package com.doctorapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;

@RestController
@RequestMapping("/api")
public class DoctorController {

	IDoctorService iDoctorService;
	
	public DoctorController(IDoctorService iDoctorService) {
        super();
        this.iDoctorService = iDoctorService;
    }
	
	    @PostMapping("/doctor")
	    void addDoctor(@RequestBody Doctor doctor) {
		 iDoctorService.addDoctor(doctor);
	    }
	    
	    @PutMapping("/doctor")
	    void updateDoctor(@RequestBody Doctor doctor) {
	    	iDoctorService.updateDoctor(doctor);
	    }
	    @DeleteMapping("/doctor")
	     void deleteDoctor(@PathVariable("doctorId")int doctorId) {
	    	iDoctorService.deleteDoctor(doctorId);
	    }
	    @GetMapping("/doctor")
	    List<Doctor> getAllDoctors() {
	        return iDoctorService.getAllDoctors();
	    }
	    

	    @GetMapping("/doctor/speciality/{speciality}")
	    List<Doctor> getBySpeciality(@PathVariable String speciality) throws DoctorNotFoundException{
	        return iDoctorService.getBySpeciality(speciality);
	    }

	    
}

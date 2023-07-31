package com.doctorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.service.IBookService;
import com.doctorapp.repository.IDoctorRepository;

@SpringBootApplication
public class SpringDoctorappApplication implements CommandLineRunner{
	
	@Autowired
	private IDoctorRepository iDoctorRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringDoctorappApplication.class, args);
	}
	
	public SpringDoctorappApplication(IDoctorRepository iDoctorRepository) {
		super();
		this.iDoctorRepository = iDoctorRepository;
	}
	
	@Override
	public void run(String...args) throws Exception{
		iDoctorRepository.getByFees(12000.00).forEach(System.out::println);
		iDoctorRepository.getAllDoctors().forEach(System.out::println);
		
	}

}

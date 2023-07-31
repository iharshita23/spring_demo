package com.doctorapp.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;
import com.doctorapp.exception.DoctorNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.repository.IDoctorRepository;

public class DoctorServiceImpl implements IDoctorService{
	@Autowired
	IDoctorRepository iDoctorRepository;
	
	public DoctorServiceImpl(IDoctorRepository iDoctorRepository) {
		this.iDoctorRepository = iDoctorRepository;
	}
	
	@Override
	public void addDoctor(Doctor doctor) {
		iDoctorRepository.insert(doctor);
		
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		iDoctorRepository.save(doctor);
		
	}

	@Override
	public void deleteDoctor(int doctorId) {
		iDoctorRepository.deleteById(doctorId);
		
	}

	@Override
	public List<Doctor> getById(int doctorId) throws DoctorNotFoundException {
		return  iDoctorRepository.getById(doctorId);
	}
	
	@Override
	public List<Doctor> getAllDoctors() {
		return iDoctorRepository.findAll();
	}

	@Override
	public List<Doctor> getByFees(double fees) throws DoctorNotFoundException {
		List<Doctor> doctor = iDoctorRepository.getByFees(fees);
		if(doctor.isEmpty())
			throw new DoctorNotFoundException("Author not found");
		return  doctor;
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) throws DoctorNotFoundException {
		List<Doctor> doctor = iDoctorRepository.findBySpeciality(speciality);
		if(doctor.isEmpty())
			throw new DoctorNotFoundException("Speciality not found");
		return  doctor;
	}

	@Override
	public List<Doctor> getByExperience(int experience) throws DoctorNotFoundException {
		List<Doctor> doctor = iDoctorRepository.findByExperience(experience);
		if(doctor.isEmpty())
			throw new DoctorNotFoundException("Experience not found");
		return  doctor;
	}

	@Override
	public List<Doctor> getByHospitalName(String hospitalName) throws DoctorNotFoundException {
		List<Doctor> doctor = iDoctorRepository.findByHospitalName(hospitalName);
		if(doctor.isEmpty())
			throw new DoctorNotFoundException("Hospital name not found");
		return  doctor;
	}

	@Override
	public List<Doctor> getByHospitalAndSpeciality(String hospitalName, String speciality)
			throws DoctorNotFoundException {
		List<Doctor> doctor = iDoctorRepository.findByHospitalAndSpeciality(hospitalName,speciality);
		if(doctor.isEmpty())
			throw new DoctorNotFoundException("Hospital name not found");
		return  doctor;
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
		List<Doctor> doctor = iDoctorRepository.findBySpecialityAndFees(speciality,fees);
		if(doctor.isEmpty())
			throw new DoctorNotFoundException("Hospital name not found");
		return  doctor;
	}

	@Override
	public List<Doctor> getBySpecialityOrExp(String speciality, int exp) throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

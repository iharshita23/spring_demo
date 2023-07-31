package com.doctorapp.model;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Doctor {
	
	private Integer doctorId;
	private String speciality;
	private int experience;
	private double fees;
	@Field(name = "hospital")
	private String hospitalName;
	
	public Doctor() {
		super();
		
	}
	public Doctor(Integer doctorId, String speciality, int experience, double fees, String hospitalName) {
		super();
		this.doctorId = doctorId;
		this.speciality = speciality;
		this.experience = experience;
		this.fees = fees;
		this.hospitalName = hospitalName;
	}

	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", speciality=" + speciality + ", experience=" + experience + ", fees="
				+ fees + ", hospitalName=" + hospitalName + "]";
	}
	
}

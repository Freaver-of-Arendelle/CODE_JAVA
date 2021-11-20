package com.yjz.model;

import java.io.Serializable;

public class Patient implements Serializable
{

	private String name;
	private String birth;
	private String gender;
	private String ID;
	private String phone;
	private String emergency;
	private String emergencyPhone;

	public Patient(String name, String birth, String gender, String iD,
			String phone, String emergency, String emergencyPhone) {
		
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		ID = iD;
		this.phone = phone;
		this.emergency = emergency;
		this.emergencyPhone = emergencyPhone;
	}

	public Patient() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

}

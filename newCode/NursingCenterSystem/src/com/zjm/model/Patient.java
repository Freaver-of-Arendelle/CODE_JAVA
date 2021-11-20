package com.zjm.model;

import java.io.Serializable;

public class Patient implements Serializable{
	private String name;
	private String birthday;
	private String gender;
	private String idnum;
	private String phone;
	private String emergencyContact;;
	private String emergencyContactPhone;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, String birthday, String gender, String idnum,
			String phone, String emergencyContact, String emergencyContactPhone) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.idnum = idnum;
		this.phone = phone;
		this.emergencyContact = emergencyContact;
		this.emergencyContactPhone = emergencyContactPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}
}

package com.yc.model;
//≤°»À
public class Patient implements java.io.Serializable {
	private String name;
	private String birthday;
	private String gender;
	private String idno;
	private String phone;
	private String emercyant;
	private String emercyphone;

	public Patient() {

	}

	public Patient(String name, String birthday, String gender, String idno,
			String phone, String emercyant, String emercyphone) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.idno = idno;
		this.phone = phone;
		this.emercyant = emercyant;
		this.emercyphone = emercyphone;
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

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmercyant() {
		return emercyant;
	}

	public void setEmercyant(String emercyant) {
		this.emercyant = emercyant;
	}

	public String getEmercyphone() {
		return emercyphone;
	}

	public void setEmercyphone(String emercyphone) {
		this.emercyphone = emercyphone;
	}

}

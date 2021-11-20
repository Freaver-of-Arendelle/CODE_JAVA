package com.yjz.model;

import java.io.Serializable;
import java.util.Date;

public class Access implements Serializable {

	private String patient;
	private String gender;
	private String model;
	private String modelform;
	private Date time;
	private String accessman;
	private String advice;

	public Access(String patient, String gender, String model,
			String modelform, Date time, String accessman, String advice) {
		this.patient = patient;
		this.gender = gender;
		this.model = model;
		this.modelform = modelform;
		this.time = time;
		this.accessman = accessman;
		this.advice = advice;
	}

	public Access() {

	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelform() {
		return modelform;
	}

	public void setModelform(String modelform) {
		this.modelform = modelform;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date date) {
		this.time = date;
	}

	public String getAccessman() {
		return accessman;
	}

	public void setAccessman(String accessman) {
		this.accessman = accessman;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

}

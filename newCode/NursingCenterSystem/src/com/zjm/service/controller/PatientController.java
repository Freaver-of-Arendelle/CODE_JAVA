package com.zjm.service.controller;

import java.util.Vector;

import com.zjm.model.Patient;

public interface PatientController {
	public abstract Boolean add(Patient patient);
	public abstract Boolean delete(Patient patient);
	public abstract Vector<Patient> query();
	public abstract Vector<String> getColNames();
	public abstract Boolean save();
	public abstract Patient getPatient(String name);
}

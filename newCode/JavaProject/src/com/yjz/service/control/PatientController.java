package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Patient;

public interface PatientController {

	public abstract Boolean register(Patient pat);
	public abstract Vector<Patient> query();
	public abstract Vector<String> getColNames();
	public abstract Boolean delete(Patient pat);
	public abstract Boolean save(Patient patient, int temp);
	public abstract Boolean add();
}

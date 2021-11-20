package com.zjm.dao.model;

import java.util.Vector;

import com.zjm.model.Patient;

public interface PatientDAO {
	public abstract void writeFile(String path);
	public abstract void add(Patient patient);
	public abstract Boolean delete(Patient patient);
	public abstract Vector<Patient> query();
	public abstract Boolean save();
	public abstract Patient getPatient(String name);
}

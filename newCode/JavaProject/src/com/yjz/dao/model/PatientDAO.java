package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Patient;

public interface PatientDAO {

	public abstract Vector<Patient> query();
	public abstract void register (Patient pat);
	public abstract void writeFile(String path);
	public abstract void delete(Patient pat);
	public abstract Boolean save(Patient patient, int temp);
	public abstract void add();
}

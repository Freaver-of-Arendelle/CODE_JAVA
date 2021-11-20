package com.zjm.dao.impl.model;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import com.zjm.dao.model.PatientDAO;
import com.zjm.dao.tool.UtilTool;
import com.zjm.model.Patient;

public class PatientDAOImpl implements PatientDAO {
	private static PatientDAOImpl instance = new PatientDAOImpl();
	
	private Vector<Patient> patients;
	private String path;

	private PatientDAOImpl() {
		patients = new Vector<Patient>();
		path = "e://abc//patient.txt";
		try {
			File file = new File(path);
			if (file.createNewFile()) {
				
			} else if (new File(path).length() != 0) {
				patients = (Vector<Patient>) UtilTool
						.getObjectBySerialize(path);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	public static PatientDAOImpl getinstance(){
		return instance;
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, patients);

	}

	@Override
	public void add(Patient patient) {
		this.patients.add(patient);
		writeFile(path);
	}

	@Override
	public Boolean delete(Patient patient) {
		Boolean flag = patients.remove(patient);
		writeFile(path);
		return flag;
	}

	@Override
	public Vector<Patient> query() {
		return (Vector<Patient>)patients;
	}

	@Override
	public Boolean save() {
		writeFile(path);
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PatientDAOImpl pdi = new PatientDAOImpl();

	}

	@Override
	public Patient getPatient(String name) {
		Patient pt = null;
		for (Patient patient : patients) {
			if (patient.getName().equals(name)) {
				pt = patient;
			}
		}
		return pt;
	}

}

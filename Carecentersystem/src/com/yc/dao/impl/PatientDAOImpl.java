package com.yc.dao.impl;

import java.io.File;
import java.util.List;
import java.util.Vector;

import com.yc.model.Patient;
import com.yc.model.Worker;
import com.yc.tool.UtilTool;

public class PatientDAOImpl {
	List<Patient> patients = new Vector<Patient>();
	String path;

	public PatientDAOImpl() {
		path = "c:\\abc\\patients.txt";
		if (new File("c:\\abc\\patients.txt").length() != 0) {
			patients = (List<Patient>) UtilTool.getObject(path);
		}

	}

	public void register(Patient patient) {
		patients.add(patient);
		writeFile(path);
	}

	public void writeFile(String path) {
		UtilTool.save(path, patients);
	}

	public Vector<Patient> query() {
		patients = (List<Patient>) UtilTool.getObject(path);
		return (Vector<Patient>) patients;
	}

	public Boolean delete(Patient patient) {
		Boolean flag = patients.remove(patient);
		writeFile(path);
		return flag;
	}
}

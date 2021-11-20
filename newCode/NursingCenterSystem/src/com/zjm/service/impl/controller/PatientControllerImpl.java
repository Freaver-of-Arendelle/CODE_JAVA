package com.zjm.service.impl.controller;

import java.util.Vector;

import com.zjm.dao.impl.model.PatientDAOImpl;
import com.zjm.dao.model.PatientDAO;
import com.zjm.model.Patient;
import com.zjm.service.controller.PatientController;

public class PatientControllerImpl implements PatientController {
	private static PatientControllerImpl instance= new PatientControllerImpl();
	
	private PatientDAO patientDao;
	
	private PatientControllerImpl() {
		this.patientDao = PatientDAOImpl.getinstance();
	}

	public static PatientControllerImpl getinstance(){
		return instance;
	}
	
	
	@Override
	public Boolean add(Patient patient) {
		Boolean flag = false;
		try {
			patientDao.add(patient);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Boolean delete(Patient patient) {
		Boolean flag = patientDao.delete(patient);
		return flag;
	}

	@Override
	public Vector<Patient> query() {
		return patientDao.query();
	}

	@Override
	public Vector<String> getColNames() {
		Vector<String> colNames = new Vector<String>();
		colNames.add("");
		colNames.add("姓名");
		colNames.add("出生日期");
		colNames.add("性别");
		colNames.add("身份证号");
		colNames.add("联系电话");
		colNames.add("紧急联系人");
		colNames.add("紧急联系人电话");
		colNames.add("");
		return colNames;
	}

	@Override
	public Boolean save() {
		Boolean flag = patientDao.save();
		return flag;
	}

	@Override
	public Patient getPatient(String name) {
		return patientDao.getPatient(name);
	}

}

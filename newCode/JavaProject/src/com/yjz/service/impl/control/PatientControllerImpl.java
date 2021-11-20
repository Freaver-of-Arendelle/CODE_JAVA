package com.yjz.service.impl.control;

import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.PatientDAO;
import com.yjz.impl.model.PatientDAOImpl;
import com.yjz.model.Patient;
import com.yjz.service.control.PatientController;

public class PatientControllerImpl implements PatientController{

	private PatientDAO pdi = new PatientDAOImpl();
	@Override
	public Boolean register(Patient pat) {
		Boolean flag = false;
		try{
			pdi.register(pat);
			flag=true;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "输入信息有误");
		}
		return flag;
	}

	@Override
	public Vector<Patient> query() {
		return pdi.query();
	}

	@Override
	public Vector<String> getColNames() {
		Vector<String> colnames =new Vector<String>();
		colnames.add("");
		colnames.add("姓名");
		colnames.add("出生日期");
		colnames.add("性别");
		colnames.add("身份证号");
		colnames.add("联系电话");
		colnames.add("紧急联系人");
		colnames.add("紧急联系人电话");
		colnames.add("");
		return colnames;
	}
	@Override
	public Boolean delete(Patient pat) {
		Boolean flag = false;
		try{
			pdi.delete(pat);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public Boolean save(Patient patient, int temp) {
		return pdi.save(patient, temp);
		
	}
	
	@Override
	public Boolean add() {
		Boolean flag = false;
		try{
			pdi.add();
			flag=true;
		}catch(Exception e){
		e.printStackTrace();
		
	}
	return flag;
}
}

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
			JOptionPane.showMessageDialog(null, "������Ϣ����");
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
		colnames.add("����");
		colnames.add("��������");
		colnames.add("�Ա�");
		colnames.add("���֤��");
		colnames.add("��ϵ�绰");
		colnames.add("������ϵ��");
		colnames.add("������ϵ�˵绰");
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

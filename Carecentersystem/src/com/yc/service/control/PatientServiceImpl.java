package com.yc.service.control;

import java.util.Vector;

import com.yc.dao.impl.PatientDAOImpl;

import com.yc.model.Patient;
import com.yc.model.Worker;

public class PatientServiceImpl {
	private PatientDAOImpl pdi;
	String path;

	public PatientServiceImpl() {
		pdi = new PatientDAOImpl();
		path = "c:\\abc\\patients.txt";
	}

	public Boolean register(Patient patient) {
		Boolean flag = true;
		try {
			pdi.register(patient);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public void save() {
		pdi.writeFile(path);
	}

	public Patient getPatient(String name) {
		Patient p = new Patient();
		for (int i = 0; i < pdi.query().size(); i++) {
			p = pdi.query().get(i);
			if (p.getName().equals(name)) {
				p = pdi.query().get(i);
				break;
			}
		}
		return p;
	}

	public Vector<Vector<Object>> query() {
		Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
		Vector<Patient> patients = pdi.query();
		for (Patient patient : patients) {
			Vector<Object> data = new Vector<Object>();
			data.add(new Boolean(false));
			data.add(patient.getName());
			data.add(patient.getBirthday());
			data.add(patient.getGender());
			data.add(patient.getIdno());
			data.add(patient.getPhone());
			data.add(patient.getEmercyant());
			data.add(patient.getEmercyphone());

			datas.add(data);
		}
		return datas;
	}

	public Vector<String> getcolNames() {
		Vector<String> cols = new Vector<String>();
		cols.add("");
		cols.add("����");
		cols.add("��������");
		cols.add("�Ա�");
		cols.add("���֤����");
		cols.add("��ϵ�绰");
		cols.add("������ϵ��");
		cols.add("������ϵ�˵绰");
		cols.add("");

		return cols;
	}
}

package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Patient;

public interface PatientController {

	/**
	 * 
	 * @param pat ע����󣨼��뼯�ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean register(Patient pat);
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Patient> query();
	/**
	 * 
	 * @return ��ȡ�����е���Ŀ
	 */
	public abstract Vector<String> getColNames();
	/**
	 * 
	 * @param pat ɾ�������Ƴ����ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean delete(Patient pat);
	/**
	 * 
	 * @param admin Ӧ����ӵĶ���
	 * @param temp Ӧ���Ƴ����������
	 * @return �Ƿ�ɹ��滻
	 */
	public abstract Boolean save(Patient patient, int temp);
	/**
	 * 
	 * @return ��ӳɹ����
	 */
	public abstract Boolean add();
}

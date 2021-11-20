package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Patient;

public interface PatientDAO {
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Patient> query();
	/**
	 * 
	 * @param pat ע�����(���뼯��)
	 */
	public abstract void register (Patient pat);
	/**
	 * 
	 * @param path д���Ӧ�ļ���·��
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param pat ɾ���Ķ���(�Ӽ������Ƴ�)
	 */
	public abstract void delete(Patient pat);
	/**
	 * 
	 * @param patient ������ӵĶ���
	 * @param temp ��Ҫ�滻���������
	 * @return
	 */
	public abstract Boolean save(Patient patient, int temp);
	/**
	 * ���
	 */
	public abstract void add();
}

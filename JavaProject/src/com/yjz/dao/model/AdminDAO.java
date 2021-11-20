package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Admin;

public interface AdminDAO {

	/**
	 * 
	 * @return ���ؼ���
	 */
	public abstract Vector<Admin> query();
	/**
	 * 
	 * @param adm ע��Ķ���(���뼯��)
	 * @return ע��ɹ����
	 */
	public abstract Boolean register (Admin adm);
	/**
	 * 
	 * @param adm ɾ���Ķ���(�Ӽ������Ƴ�)
	 */
	public abstract void delete(Admin adm);
	/**
	 * 
	 * @param path д���Ӧ�ļ���·��
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param adm ��¼�Ķ���(�뼯���еĶ����Ƿ�ƥ��)
	 * @return ��¼�ɹ����
	 */
	public abstract Boolean login(Admin adm);
	/**
	 * 
	 * @param adm Ӧ����ӵĶ���
	 * @param temp Ӧ���Ƴ����������
	 * @return �Ƿ�ɹ��滻
	 */
	public abstract Boolean save(Admin adm,int temp);
	
}

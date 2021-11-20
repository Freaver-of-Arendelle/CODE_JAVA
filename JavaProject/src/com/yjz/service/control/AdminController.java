package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Admin;


public interface AdminController {
	/**
	 * 
	 * @param admin ע����󣨼��뼯�ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean register(Admin admin);
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Admin> query();
	/**
	 * 
	 * @return ��ȡ�����е���Ŀ
	 */
	public abstract Vector<String> getColNames();
	/**
	 * 
	 * @param admin ɾ�������Ƴ����ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean delete (Admin admin);
	/**
	 * 
	 * @param admin ƥ�����
	 * @return �ɹ����
	 */
	public abstract Boolean login (Admin admin);
	/**
	 * 
	 * @param admin Ӧ����ӵĶ���
	 * @param temp Ӧ���Ƴ����������
	 * @return �Ƿ�ɹ��滻
	 */
	public abstract Boolean save (Admin admin,int temp);
}


package com.yjz.dao.model;

import com.yjz.model.MaxAdmin;

public interface MaxAdminDAO {
	
	/**
	 * 
	 * @param maxadmin ע��Ķ���(���뼯��)
	 */
	public abstract void register(MaxAdmin maxadmin);
	/**
	 * 
	 * @param path д���Ӧ�ļ���·��
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param maxadmin ��¼�Ķ���(�뼯���еĶ����Ƿ�ƥ��)
	 * @return �ɹ����
	 */
	public abstract Boolean login(MaxAdmin maxadmin);
	
}

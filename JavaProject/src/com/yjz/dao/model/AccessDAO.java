package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Access;
import com.yjz.model.Admin;

public interface AccessDAO {
	/**
	 * 
	 * @return ���ؼ���
	 */
	public abstract Vector<Access> query();
	/**
	 * 
	 * @param path д���Ӧ�ļ���·��
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param access ע��Ķ���(���뼯��)
	 * @return ע��ɹ����
	 */
	public abstract Boolean register(Access access);
}

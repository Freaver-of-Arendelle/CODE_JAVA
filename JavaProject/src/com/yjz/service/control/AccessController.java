package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Access;

public interface AccessController {
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Access> query();
	/**
	 * 
	 * @return ��ȡ�����е���Ŀ
	 */
	public abstract Vector<String> getColnames();
	/**
	 * 
	 * @param access ע�����(���뼯��)
	 * @return �ɹ����
	 */
	public abstract Boolean register(Access access);
}

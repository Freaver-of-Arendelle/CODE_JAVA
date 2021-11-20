package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Model;
import com.yjz.model.Question;

public interface ModelDAO {
	/**
	 * 
	 * @param path д���Ӧ�ļ���·��
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param model ��Ҫɾ����ģ��
	 * @return �ɹ����
	 */
	public abstract Boolean delete(Model model);
	/**
	 * 
	 * @param model ��Ҫ��ӵ�ģ��
	 * @return �ɹ����
	 */
	public abstract Boolean add(Model model);
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Model> query();
	/**
	 * ɾ��ģ���е�����
	 * @param model ��Ӧ��ģ��
	 * @param question ����ɾ��������
	 * @return �ɹ����
	 */
	public abstract Boolean delete(Model model,Question question);
	/**
	 * ���ģ���е�����
	 * @param model ��Ӧ��ģ��
	 * @param question ������ӵ�����
	 * @return �ɹ����
	 */
	public abstract Boolean add(Model model,Question question);
}

package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Question;

public interface QuestionDAO {
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Question> query();
	/**
	 * 
	 * @param question ������ӵ�����
	 * @return �ɹ����
	 */
	public abstract Boolean add(Question question);
	/**
	 * 
	 * @param question ����ɾ��������
	 * @return �ɹ����
	 */
	public abstract Boolean delete (Question question);
	/**
	 * 
	 * @param path д���Ӧ�ļ���·��
	 */
	public abstract void writeFile(String path);
}

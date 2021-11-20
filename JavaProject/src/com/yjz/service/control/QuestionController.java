package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Question;

public interface QuestionController {
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Question> query();
	/**
	 * 
	 * @param question ������⣨���뼯�ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean add(Question question);
	/**
	 * 
	 * @param question ɾ�����⣨�Ƴ����ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean delete (Question question);
	/**
	 * 
	 * @return ��ȡ�����е���Ŀ
	 */
	public abstract Vector <String> getColnames();
}

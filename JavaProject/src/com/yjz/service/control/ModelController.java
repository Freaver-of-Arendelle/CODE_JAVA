package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Model;
import com.yjz.model.Question;

public interface ModelController {
	/**
	 * 
	 * @param model ɾ�������Ƴ����ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean delete(Model model);
	/**
	 * 
	 * @param model ��Ӷ��󣨼��뼯�ϣ�
	 * @return �ɹ����
	 */
	public abstract Boolean add(Model model);
	/**
	 * 
	 * @return ��ȡ����
	 */
	public abstract Vector<Model> query();
	/**
	 * 
	 * @return ��ȡ�����е���Ŀ
	 */
	public abstract Vector<String> getColNames();
	/**
	 * 
	 * @return ��ȡ��������е���Ŀ
	 */
	public abstract Vector<String> getScanColnames();
	/**
	 * ɾ��ģ���е�����
	 * @param model ����Ӧ��ģ��
	 * @param question ģ���е�����
	 * @return �ɹ����
	 */
	public abstract Boolean delete(Model model,Question question);
	/**
	 * ������Ӧģ�������
	 * @param model ����Ӧ��ģ��
	 * @param question ģ���е�����
	 * @return �ɹ����
	 */
	public abstract Boolean add(Model model,Question question);
}

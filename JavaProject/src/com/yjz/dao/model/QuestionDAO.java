package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Question;

public interface QuestionDAO {
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Question> query();
	/**
	 * 
	 * @param question 所需添加的问题
	 * @return 成功与否
	 */
	public abstract Boolean add(Question question);
	/**
	 * 
	 * @param question 所需删除的问题
	 * @return 成功与否
	 */
	public abstract Boolean delete (Question question);
	/**
	 * 
	 * @param path 写入对应文件的路径
	 */
	public abstract void writeFile(String path);
}

package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Question;

public interface QuestionController {
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Question> query();
	/**
	 * 
	 * @param question 添加问题（加入集合）
	 * @return 成功与否
	 */
	public abstract Boolean add(Question question);
	/**
	 * 
	 * @param question 删除问题（移出集合）
	 * @return 成功与否
	 */
	public abstract Boolean delete (Question question);
	/**
	 * 
	 * @return 获取表格各列的题目
	 */
	public abstract Vector <String> getColnames();
}

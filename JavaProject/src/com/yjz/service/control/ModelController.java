package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Model;
import com.yjz.model.Question;

public interface ModelController {
	/**
	 * 
	 * @param model 删除对象（移出集合）
	 * @return 成功与否
	 */
	public abstract Boolean delete(Model model);
	/**
	 * 
	 * @param model 添加对象（加入集合）
	 * @return 成功与否
	 */
	public abstract Boolean add(Model model);
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Model> query();
	/**
	 * 
	 * @return 获取表格各列的题目
	 */
	public abstract Vector<String> getColNames();
	/**
	 * 
	 * @return 获取详情表格各列的题目
	 */
	public abstract Vector<String> getScanColnames();
	/**
	 * 删除模板中的问题
	 * @param model 所对应的模板
	 * @param question 模板中的问题
	 * @return 成功与否
	 */
	public abstract Boolean delete(Model model,Question question);
	/**
	 * 添加入对应模板的问题
	 * @param model 所对应的模板
	 * @param question 模板中的问题
	 * @return 成功与否
	 */
	public abstract Boolean add(Model model,Question question);
}

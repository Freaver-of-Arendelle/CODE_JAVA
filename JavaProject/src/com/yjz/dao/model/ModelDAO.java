package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Model;
import com.yjz.model.Question;

public interface ModelDAO {
	/**
	 * 
	 * @param path 写入对应文件的路径
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param model 需要删除的模板
	 * @return 成功与否
	 */
	public abstract Boolean delete(Model model);
	/**
	 * 
	 * @param model 需要添加的模板
	 * @return 成功与否
	 */
	public abstract Boolean add(Model model);
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Model> query();
	/**
	 * 删除模板中的问题
	 * @param model 对应的模板
	 * @param question 所需删除的问题
	 * @return 成功与否
	 */
	public abstract Boolean delete(Model model,Question question);
	/**
	 * 添加模板中的问题
	 * @param model 对应的模板
	 * @param question 所需添加的问题
	 * @return 成功与否
	 */
	public abstract Boolean add(Model model,Question question);
}

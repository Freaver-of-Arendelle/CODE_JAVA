package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Access;

public interface AccessController {
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Access> query();
	/**
	 * 
	 * @return 获取表格各列的题目
	 */
	public abstract Vector<String> getColnames();
	/**
	 * 
	 * @param access 注册对象(加入集合)
	 * @return 成功与否
	 */
	public abstract Boolean register(Access access);
}

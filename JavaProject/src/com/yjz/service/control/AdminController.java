package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Admin;


public interface AdminController {
	/**
	 * 
	 * @param admin 注册对象（加入集合）
	 * @return 成功与否
	 */
	public abstract Boolean register(Admin admin);
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Admin> query();
	/**
	 * 
	 * @return 获取表格各列的题目
	 */
	public abstract Vector<String> getColNames();
	/**
	 * 
	 * @param admin 删除对象（移出集合）
	 * @return 成功与否
	 */
	public abstract Boolean delete (Admin admin);
	/**
	 * 
	 * @param admin 匹配对象
	 * @return 成功与否
	 */
	public abstract Boolean login (Admin admin);
	/**
	 * 
	 * @param admin 应被添加的对象
	 * @param temp 应被移除对象的索引
	 * @return 是否成功替换
	 */
	public abstract Boolean save (Admin admin,int temp);
}


package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Patient;

public interface PatientController {

	/**
	 * 
	 * @param pat 注册对象（加入集合）
	 * @return 成功与否
	 */
	public abstract Boolean register(Patient pat);
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Patient> query();
	/**
	 * 
	 * @return 获取表格各列的题目
	 */
	public abstract Vector<String> getColNames();
	/**
	 * 
	 * @param pat 删除对象（移出集合）
	 * @return 成功与否
	 */
	public abstract Boolean delete(Patient pat);
	/**
	 * 
	 * @param admin 应被添加的对象
	 * @param temp 应被移除对象的索引
	 * @return 是否成功替换
	 */
	public abstract Boolean save(Patient patient, int temp);
	/**
	 * 
	 * @return 添加成功与否
	 */
	public abstract Boolean add();
}

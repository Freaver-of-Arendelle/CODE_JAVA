package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Patient;

public interface PatientDAO {
	/**
	 * 
	 * @return 获取集合
	 */
	public abstract Vector<Patient> query();
	/**
	 * 
	 * @param pat 注册对象(加入集合)
	 */
	public abstract void register (Patient pat);
	/**
	 * 
	 * @param path 写入对应文件的路径
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param pat 删除的对象(从集合中移除)
	 */
	public abstract void delete(Patient pat);
	/**
	 * 
	 * @param patient 所需添加的对象
	 * @param temp 需要替换对象的索引
	 * @return
	 */
	public abstract Boolean save(Patient patient, int temp);
	/**
	 * 添加
	 */
	public abstract void add();
}

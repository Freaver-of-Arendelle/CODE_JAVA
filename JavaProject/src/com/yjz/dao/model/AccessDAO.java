package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Access;
import com.yjz.model.Admin;

public interface AccessDAO {
	/**
	 * 
	 * @return 返回集合
	 */
	public abstract Vector<Access> query();
	/**
	 * 
	 * @param path 写入对应文件的路径
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param access 注册的对象(加入集合)
	 * @return 注册成功与否
	 */
	public abstract Boolean register(Access access);
}

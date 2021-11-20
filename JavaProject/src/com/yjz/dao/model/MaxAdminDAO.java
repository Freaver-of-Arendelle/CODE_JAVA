package com.yjz.dao.model;

import com.yjz.model.MaxAdmin;

public interface MaxAdminDAO {
	
	/**
	 * 
	 * @param maxadmin 注册的对象(加入集合)
	 */
	public abstract void register(MaxAdmin maxadmin);
	/**
	 * 
	 * @param path 写入对应文件的路径
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param maxadmin 登录的对象(与集合中的对象是否匹配)
	 * @return 成功与否
	 */
	public abstract Boolean login(MaxAdmin maxadmin);
	
}

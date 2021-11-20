package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Admin;

public interface AdminDAO {

	/**
	 * 
	 * @return 返回集合
	 */
	public abstract Vector<Admin> query();
	/**
	 * 
	 * @param adm 注册的对象(加入集合)
	 * @return 注册成功与否
	 */
	public abstract Boolean register (Admin adm);
	/**
	 * 
	 * @param adm 删除的对象(从集合中移除)
	 */
	public abstract void delete(Admin adm);
	/**
	 * 
	 * @param path 写入对应文件的路径
	 */
	public abstract void writeFile(String path);
	/**
	 * 
	 * @param adm 登录的对象(与集合中的对象是否匹配)
	 * @return 登录成功与否
	 */
	public abstract Boolean login(Admin adm);
	/**
	 * 
	 * @param adm 应被添加的对象
	 * @param temp 应被移除对象的索引
	 * @return 是否成功替换
	 */
	public abstract Boolean save(Admin adm,int temp);
	
}

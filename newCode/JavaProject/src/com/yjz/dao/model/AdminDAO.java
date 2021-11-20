package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Admin;

public interface AdminDAO {

	public abstract Vector<Admin> query();
	public abstract Boolean register (Admin adm);
	public abstract void delete(Admin adm);
	public abstract void writeFile(String path);
	public abstract Boolean login(Admin adm);
	public abstract Boolean save(Admin adm,int temp);
	
}

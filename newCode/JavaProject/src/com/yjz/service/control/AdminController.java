package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Admin;


public interface AdminController {

	public abstract Boolean register(Admin admin);
	public abstract Vector<Admin> query();
	public abstract Vector<String> getColNames();
	public abstract Boolean delete (Admin admin);
	public abstract Boolean login (Admin admin);
	public abstract Boolean save (Admin admin,int temp);
}

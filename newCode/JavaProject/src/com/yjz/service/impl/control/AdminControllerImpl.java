package com.yjz.service.impl.control;

import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.AdminDAO;
import com.yjz.impl.model.AdminDAOImpl;
import com.yjz.model.Admin;
import com.yjz.service.control.AdminController;

public class AdminControllerImpl implements AdminController
{
	private AdminDAO adi = new AdminDAOImpl();
	
	@Override
	public Boolean delete(Admin admin) {
		Boolean flag = false; 
		try{
			adi.delete(admin);
			flag=true;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "删除失败");
		}	
		return flag;
	}
	
	@Override
	public Boolean register(Admin admin) {
		Boolean flag = false;
		try{
			flag = adi.register(admin);
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "输入信息有误");
		}	
		return flag;
	}

	@Override
	public Vector<Admin> query() {		
		return adi.query();
	}

	@Override
	public Vector<String> getColNames() {
		Vector<String> colnames = new Vector<String>();
		colnames.add("");
		colnames.add("用户名");
		colnames.add("姓名");
		colnames.add("出生日期");
		colnames.add("专长");
		colnames.add("职称");
		colnames.add("联系电话");
		return colnames;
	}

	@Override
	public Boolean login(Admin admin) {
		Boolean flag = false;
		if(adi.login(admin)){
			flag = true;
		}
		return flag;
	}

	@Override
	public Boolean save(Admin admin,int temp) {
		Boolean flag = false;
		if(adi.save(admin,temp)){
			flag = true;
		}
		return flag;
	}
	
	
}

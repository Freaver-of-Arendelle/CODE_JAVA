package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.MaxAdminDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.MaxAdmin;

public class MaxAdminDAOImpl implements MaxAdminDAO{
	private static MaxAdminDAOImpl instance= new MaxAdminDAOImpl();
	
	Vector<MaxAdmin> maxadmin = new Vector<MaxAdmin>();
	
	public static MaxAdminDAOImpl getinstance(){
		return instance;
	}
	
	private MaxAdminDAOImpl (){
		File f = new File("c://abc//MaxAdmin.txt");
		if(f.length()!=0){
			maxadmin=(Vector<MaxAdmin>)UtilTool.getFileBySerialize("c://abc//MaxAdmin.txt");
		}else{
			JOptionPane.showMessageDialog(null, "bucunzai");
		}
	}
	@Override
	public void register(MaxAdmin maxadmin) {
		this.maxadmin.add(maxadmin);
		writeFile("c://abc//MaxAdmin.txt");
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, maxadmin);
	}
	@Override
	public Boolean login(MaxAdmin maxadmin) {
		Boolean flag  = false;
		for (MaxAdmin max : this.maxadmin) {
			if(max.getPassword().equals(maxadmin.getPassword())&&max.getAccount().equals(maxadmin.getAccount())){
				flag =true;
				break;
			}
			
		}
		return flag;
	}
	
//	public static void main(String[] args) {
//		MaxAdminDAOImpl max = new MaxAdminDAOImpl();
//		System.out.println(max.login(new MaxAdmin("123","123")));
//		
//	}
}

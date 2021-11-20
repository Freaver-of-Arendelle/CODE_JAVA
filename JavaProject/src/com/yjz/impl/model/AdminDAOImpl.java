package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.AdminDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.Admin;

public class AdminDAOImpl implements AdminDAO{
	private static AdminDAOImpl instance= new AdminDAOImpl();
	Vector<Admin> admin = new Vector<Admin>();

	private AdminDAOImpl (){
		File f = new File("c://abc//Admin.txt");
		if(f.length()!=0){
			admin = (Vector<Admin>) UtilTool.getFileBySerialize("c://abc//Admin.txt");
		}
	}
	public static AdminDAOImpl getinstance(){
		return instance;
	}
	@Override
	public Vector<Admin> query() //��ѯ
	{
		return admin;
	}

	int i=1;
	@Override
	public Boolean register(Admin adm) //ע��
	{
		Boolean flag = false;
		int temp = 0;
		for (Admin ad : admin) {
			if(!ad.getAccount().equals(adm.getAccount())||!ad.getPassword().equals(adm.getPassword())){
				temp++;
			}
		}
		if(temp==admin.size()){
			flag = true;
		adm.setUserName("����"+i);
		adm.setRealName("����"+i);
		adm.setBirth("����"+i);
		adm.setMajor("����"+i);
		adm.setJob("����"+i);
		adm.setPhone("����"+i);
		admin.add(adm);
		i++;
		writeFile("c://abc//Admin.txt");
		return flag;
		}else{
			JOptionPane.showMessageDialog(null, "���û��Ѵ���");
			return flag;
		}
	}

	@Override
	public void delete(Admin adm) {
		admin.remove(adm);
		writeFile("c://abc//Admin.txt");
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, admin);
	}

	@Override
	public Boolean login(Admin adm) {
		Boolean flag = false;
		for (Admin admin : this.admin) {
			if(admin.getPassword().equals(adm.getPassword())&&admin.getAccount().equals(adm.getAccount())){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	@Override
	public Boolean save(Admin adm,int temp) {
		Boolean flag = false;
		try{
			admin.remove(temp);
			admin.add(temp, adm);
			writeFile("c://abc//Admin.txt");
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
//	public static void main(String[] args) {
//		Admin adm1 = new Admin("1234","1234","01","wei","001","01","A","110");
//		Admin adm2 = new Admin("123","123","02","tian","002","02","B","119");
//		Admin adm3 = new Admin("12345","12345","03","ning","003","01","A","120");
//		AdminDAOImpl admin =  new AdminDAOImpl();
//		admin.query().add(adm1);
//		admin.query().add(adm2);
//		admin.query().add(adm3);
//		admin.writeFile("c://abc//Admin.txt");
//		System.out.println(admin.login(adm1));
//		
//
//	}
	
	
}

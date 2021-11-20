package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import com.yjz.dao.model.AccessDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.Access;
import com.yjz.model.Admin;

public class AccessDAOImpl implements AccessDAO{

	Vector<Access> access = new Vector<Access>();
	public AccessDAOImpl(){
		File f = new File("c://abc//Access.txt");
		if(f.length()!=0){
			access = (Vector<Access>) UtilTool.getFileBySerialize("c://abc//Access.txt");
		}
	}
	@Override
	public Vector<Access> query() {
		return access;
	}

	@Override
	public Boolean login(Access access) {
		Boolean flag = false; 
		try{
			this.access.add(access);
			flag=true;
			writeFile("c://abc//Access.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize("c://abc//Access.txt", access);
		
	}
}

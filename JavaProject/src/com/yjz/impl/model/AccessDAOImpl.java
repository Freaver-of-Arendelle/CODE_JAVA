package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import com.yjz.dao.model.AccessDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.Access;
import com.yjz.model.Admin;

public class AccessDAOImpl implements AccessDAO{
	private static AccessDAOImpl instance = new AccessDAOImpl();
	Vector<Access> access = new Vector<Access>();
	private AccessDAOImpl(){
		File f = new File("c://abc//Access.txt");
		if(f.length()!=0){
			access = (Vector<Access>) UtilTool.getFileBySerialize("c://abc//Access.txt");
			//若文件存在，获得目标文件中的对象
		}
	}
	public static AccessDAOImpl getinstance(){
		return instance;
	}
	@Override
	public Vector<Access> query() {
		return access;
	}

	@Override
	public Boolean register(Access access) {
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

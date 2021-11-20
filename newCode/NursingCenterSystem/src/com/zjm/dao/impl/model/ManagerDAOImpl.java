package com.zjm.dao.impl.model;

import java.io.File;
import java.util.Vector;

import com.zjm.dao.model.ManagerDAO;
import com.zjm.dao.tool.UtilTool;
import com.zjm.model.Manager;
import com.zjm.model.Worker;

public class ManagerDAOImpl implements ManagerDAO {
	private static ManagerDAOImpl instance = new ManagerDAOImpl();
	private Vector<Manager> managers;
	
	private ManagerDAOImpl() {
		managers = new Vector<Manager>();
		if (new File("e://abc//manager.txt").length()!=0) {
			managers = (Vector<Manager>) UtilTool.getObjectBySerialize("e://abc//manager.txt");
		}
	}
	
	public static ManagerDAOImpl getinstance(){
		return instance;
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, managers);

	}

	@Override
	public Boolean login(Manager manager) {
		Boolean flag = false;
		for (Manager m : managers) {
			if (m.getAccount().equals(manager.getAccount())&&
					m.getPassword().equals(manager.getPassword())) {
				flag = true;break;
			}
		}
		return flag;
	}

	@Override
	public void register(Manager manager) {
		this.managers.add(manager);
		writeFile("e://abc//manager.txt");

	}
	
	public static void main(String[] args) {
		ManagerDAOImpl mdi = new ManagerDAOImpl();
		mdi.register(new Manager("zjm","111"));
		Boolean s = mdi.login(new Manager("admin","000"));
		System.out.println(s);
		 s = mdi.login(new Manager("zjsssm","111"));
		System.out.println(s);
	}

}

package com.yc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.model.Manager;
import com.yc.model.Worker;
import com.yc.tool.UtilTool;

public class ManagerDAOImpl {
	List<Manager> managers = new ArrayList<Manager>();

	public void reg(Manager manager) {
		managers.add(manager);
	}

	public void writeFile(String path) {
		UtilTool.save(path, managers);
	}

	public Boolean login(Manager manager) {
		Boolean flag = false;
		managers = (List<Manager>) UtilTool
				.getObject("c:\\abc\\managers.txt");
		for (Manager m : managers) {
			if (m.getAccount().equals(manager.getAccount())
					&& m.getPassword().equals(manager.getPassword())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public ArrayList<Manager> query() {
		 managers = (List<Manager>) UtilTool
				.getObject("c:\\abc\\managers.txt");
		return (ArrayList<Manager>) managers;
	}

	public static void main(String[] args) {
		 Manager manager =new Manager();
		 ManagerDAOImpl mdi =new ManagerDAOImpl();
		 mdi.reg(new Manager("admin1","11111"));
		 mdi.reg(new Manager("admin2","22222"));
		 mdi.writeFile("c:\\abc\\managers.txt");
	}
}

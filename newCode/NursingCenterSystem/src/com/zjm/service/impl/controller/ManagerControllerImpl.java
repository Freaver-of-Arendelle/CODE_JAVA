package com.zjm.service.impl.controller;

import com.zjm.dao.impl.model.ManagerDAOImpl;
import com.zjm.dao.model.ManagerDAO;
import com.zjm.model.Manager;
import com.zjm.service.controller.ManagerController;

public class ManagerControllerImpl implements ManagerController {

	private static ManagerControllerImpl instance = new ManagerControllerImpl();
	private ManagerDAO managerDao;
	private ManagerControllerImpl() {
		managerDao = ManagerDAOImpl.getinstance();
	}
	
	public static ManagerControllerImpl getinstance(){
		return instance;
	}
	
	@Override
	public Boolean login(Manager manager) {
		Boolean flag = managerDao.login(manager);
		return flag;
	}

}

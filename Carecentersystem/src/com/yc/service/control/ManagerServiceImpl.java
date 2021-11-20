package com.yc.service.control;

import com.yc.dao.impl.ManagerDAOImpl;
import com.yc.model.Manager;


public class ManagerServiceImpl {
	ManagerDAOImpl mdi= new ManagerDAOImpl();

	public String login(Manager manager) {
		return mdi.login(manager) ? "µÇÂ½³É¹¦" : "Ê§°Ü";
	}
}

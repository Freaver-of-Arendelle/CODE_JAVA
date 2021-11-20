package com.yjz.service.impl.control;

import com.yjz.dao.model.MaxAdminDAO;
import com.yjz.impl.model.MaxAdminDAOImpl;
import com.yjz.model.MaxAdmin;
import com.yjz.service.control.MaxAdminController;

public class MaxAdminControllerImpl implements MaxAdminController{

	MaxAdminDAO mad = new MaxAdminDAOImpl();
	@Override
	public Boolean login(MaxAdmin maxadmin) {
		Boolean flag =false;
		if(mad.login(maxadmin)){
			flag=true;
		}
		return flag;
	}

}

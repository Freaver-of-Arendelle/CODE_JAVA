package com.yjz.service.impl.control;

import java.util.Vector;

import com.yjz.dao.model.AccessDAO;
import com.yjz.impl.model.AccessDAOImpl;
import com.yjz.model.Access;
import com.yjz.service.control.AccessController;

public class AccessControllerImpl implements AccessController{

	private static AccessControllerImpl instance = new AccessControllerImpl();
	
	private AccessControllerImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	AccessDAO ad = AccessDAOImpl.getinstance();
	@Override
	public Vector<Access> query() {
		
		return ad.query();
	}

	public static AccessControllerImpl getinstance(){
		return instance;
	}
	@Override
	public Boolean register(Access access) {
		
		return ad.register(access);
	}

	@Override
	public Vector<String> getColnames() {
		Vector<String> colnames = new Vector<String>();
		colnames.add("姓名");
		colnames.add("性别");
		colnames.add("模板名称");
		colnames.add("模板类型");
		colnames.add("时间");
		colnames.add("评估人");
		colnames.add("建议");
		return colnames;
		
	}
	
}

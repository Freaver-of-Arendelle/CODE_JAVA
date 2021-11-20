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
		colnames.add("����");
		colnames.add("�Ա�");
		colnames.add("ģ������");
		colnames.add("ģ������");
		colnames.add("ʱ��");
		colnames.add("������");
		colnames.add("����");
		return colnames;
		
	}
	
}

package com.yjz.service.impl.control;

import java.util.Vector;

import com.yjz.dao.model.AccessDAO;
import com.yjz.impl.model.AccessDAOImpl;
import com.yjz.model.Access;
import com.yjz.service.control.AccessController;

public class AccessControllerImpl implements AccessController{

	AccessDAO ad = new AccessDAOImpl();
	@Override
	public Vector<Access> query() {
		
		return ad.query();
	}

	@Override
	public Boolean login(Access access) {
		
		return ad.login(access);
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

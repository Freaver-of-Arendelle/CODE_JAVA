package com.zjm.service.impl.controller;

import java.util.Vector;

import com.zjm.dao.impl.model.HistoryDAOImpl;
import com.zjm.dao.model.HistoryDAO;
import com.zjm.model.History;
import com.zjm.service.controller.HistoryController;

public class HistoryControllerImpl implements HistoryController {

	private static HistoryControllerImpl instance = new HistoryControllerImpl();
	private HistoryDAO historyDao;
	
	
	
	private HistoryControllerImpl() {
		this.historyDao = HistoryDAOImpl.getinstance();
	}

	
	public static HistoryControllerImpl getinstance(){
		return instance;
	}
	
	@Override
	public Boolean add(History history) {
		Boolean flag = false;
		try {
			historyDao.add(history);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Boolean delete(History history) {
		Boolean flag = historyDao.delete(history);
		return flag;
	}

	@Override
	public Vector<History> query() {
		return historyDao.query();
	}

	@Override
	public Vector<String> getColNames() {
		Vector<String> colNames = new Vector<String>();
		colNames.add("����");
		colNames.add("�Ա�");
		colNames.add("ģ������");
		colNames.add("ģ������");
		colNames.add("ʱ��");
		colNames.add("������");
		colNames.add("����");
		return colNames;
	}

	@Override
	public Boolean save() {
		Boolean flag = false;
		flag = historyDao.save();
		return flag;
	}

}

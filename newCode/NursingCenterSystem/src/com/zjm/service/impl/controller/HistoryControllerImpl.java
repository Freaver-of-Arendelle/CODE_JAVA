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
		colNames.add("姓名");
		colNames.add("性别");
		colNames.add("模板名称");
		colNames.add("模板类型");
		colNames.add("时间");
		colNames.add("评估人");
		colNames.add("建议");
		return colNames;
	}

	@Override
	public Boolean save() {
		Boolean flag = false;
		flag = historyDao.save();
		return flag;
	}

}

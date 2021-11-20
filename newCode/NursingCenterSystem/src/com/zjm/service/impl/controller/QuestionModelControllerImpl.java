package com.zjm.service.impl.controller;

import java.util.Vector;

import com.zjm.dao.impl.model.QuestionModelDAOImpl;
import com.zjm.dao.model.QuestionModelDAO;
import com.zjm.model.QuestionModel;
import com.zjm.service.controller.QuestionModelController;

public class QuestionModelControllerImpl implements QuestionModelController {

	private static QuestionModelControllerImpl instance = new QuestionModelControllerImpl();
	
	private QuestionModelDAO quesModelDao;
	private QuestionModelControllerImpl() {
		quesModelDao = QuestionModelDAOImpl.getinstance();
	}
	
	public static QuestionModelControllerImpl getinstance(){
		return instance;
	}
	
	@Override
	public Boolean add(QuestionModel quesModel) {
		Boolean flag = false;
		try {
			quesModelDao.add(quesModel);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Boolean delete(QuestionModel quesModel) {
		Boolean flag = quesModelDao.delete(quesModel);
		return flag;
	}

	@Override
	public Vector<QuestionModel> query() {
		return quesModelDao.query();
	}

	@Override
	public Vector<String> getColNames() {
		Vector<String> colNames = new Vector<String>();
		colNames.add("");
		colNames.add("ID");
		colNames.add("题目");
		colNames.add("类型");
		return colNames;
	}

	@Override
	public Boolean save() {
		Boolean flag = false;
		flag = quesModelDao.save();
		return flag;
	}

	@Override
	public QuestionModel getQuesModel(String id) {
		return quesModelDao.getQuesModel(id);
	}

}

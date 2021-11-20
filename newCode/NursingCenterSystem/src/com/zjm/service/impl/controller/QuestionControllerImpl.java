package com.zjm.service.impl.controller;

import java.util.Vector;

import com.zjm.dao.impl.model.QuestionDAOImpl;
import com.zjm.dao.model.QuestionDAO;
import com.zjm.model.Question;
import com.zjm.service.controller.QuestionController;

public class QuestionControllerImpl implements QuestionController {

	private static QuestionControllerImpl instance = new QuestionControllerImpl();
	
	private QuestionDAO questionDao;
	
	private QuestionControllerImpl() {
		this.questionDao = QuestionDAOImpl.getinstance();
	}

	public static QuestionControllerImpl getinstance(){
		return instance;
	}
	
	
	@Override
	public Boolean add(Question question) {
		Boolean flag = false;
		try {
			questionDao.add(question);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Boolean delete(Question question) {
		Boolean flag = questionDao.delete(question);
		return flag;
	}

	@Override
	public Vector<Question> query() {
		return questionDao.query();
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
		flag = questionDao.save();
		return flag;
	}

	@Override
	public Question getQuestion(String id) {
		return questionDao.getQuestion(id);
	}

}

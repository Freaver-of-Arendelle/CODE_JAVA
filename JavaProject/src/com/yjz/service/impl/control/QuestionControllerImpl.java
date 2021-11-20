package com.yjz.service.impl.control;

import java.util.Vector;

import com.yjz.dao.model.QuestionDAO;
import com.yjz.impl.model.QuestionDAOImpl;
import com.yjz.model.Question;
import com.yjz.service.control.QuestionController;

public class QuestionControllerImpl implements QuestionController {
	
	private static QuestionControllerImpl instance = new QuestionControllerImpl();
	
	QuestionDAO qd = QuestionDAOImpl.getinstance();

	
	private QuestionControllerImpl() {
		super();
	}

	public static QuestionControllerImpl getinstance(){
		return instance;
	}
	
	@Override
	public Vector<Question> query() {
		return qd.query();
	}

	@Override
	public Boolean add(Question question) {
		return qd.add(question);
	}

	@Override
	public Boolean delete(Question question) {
		return qd.delete(question);
	}

	@Override
	public Vector<String> getColnames() {
		Vector<String> colnames = new Vector<String>();
		colnames.add("");
		colnames.add("ID");
		colnames.add("题目");
		colnames.add("类型");
		return colnames;
	}
}

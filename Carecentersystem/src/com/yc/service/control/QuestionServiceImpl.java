package com.yc.service.control;

import java.util.Vector;

import com.yc.dao.impl.QuestionDAOImpl;
import com.yc.model.Patient;
import com.yc.model.Question;

public class QuestionServiceImpl {
	private QuestionDAOImpl qdi;
	String path;

	public QuestionServiceImpl() {
		qdi = new QuestionDAOImpl();
		path = "c:\\abc\\patients.txt";
	}

	public Boolean register(Question question) {
		Boolean flag = true;
		try {
			qdi.register(question);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public void save() {
		qdi.writeFile(path);
	}

	public Vector<Vector<Object>> query() {
		Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
		Vector<Question> questions = qdi.query();
		for (Question question : questions) {
			Vector<Object> data = new Vector<Object>();
			data.add(new Boolean(false));
			data.add(question.getId());
			data.add(question.getQuestion());
			data.add(question.getType());
			datas.add(data);
		}
		return datas;
	}
	public Question getQuestion(String id) {
		return qdi.getQuestion(id);
	}
	public Vector<String> getcolNames() {
		Vector<String> cols = new Vector<String>();
		cols.add("");
		cols.add("ID");
		cols.add("题目");
		cols.add("类型");
		return cols;
	}
}

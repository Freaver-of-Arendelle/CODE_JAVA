package com.zjm.dao.impl.model;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import com.zjm.dao.model.QuestionDAO;
import com.zjm.dao.tool.UtilTool;
import com.zjm.model.Question;

public class QuestionDAOImpl implements QuestionDAO {

	private static QuestionDAOImpl instance = new QuestionDAOImpl();
	
	private Vector<Question> questions;
	private String path;

	private QuestionDAOImpl() {
		questions = new Vector<Question>();
		path = "e://abc//question.txt";
		try {
			File file = new File(path);
			if (file.createNewFile()) {

			} else if (new File(path).length() != 0) {
				questions = (Vector<Question>) UtilTool
						.getObjectBySerialize(path);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	public static QuestionDAOImpl getinstance(){
		return instance;
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, questions);

	}

	@Override
	public void add(Question question) {
		this.questions.add(question);
		writeFile(path);

	}

	@Override
	public Boolean delete(Question question) {
		Boolean flag = questions.remove(question);
		writeFile(path);
		return flag;
	}

	@Override
	public Vector<Question> query() {
		return (Vector<Question>) this.questions;
	}

	@Override
	public Boolean save() {
		writeFile(path);
		return null;
	}

	@Override
	public Question getQuestion(String id) {
		Question ques = null;
		for (Question question : questions) {
			if (question.getId() == Integer.parseInt(id)) {
				ques = question;
				break;
			}
		}
		return ques;
	}

	public static void main(String[] args) {
		QuestionDAOImpl qdi = new QuestionDAOImpl();
		Question a = new Question(1,"1","1","1","1","1");
		Question b = new Question(2,"2","2","2","2","2");
		qdi.add(a);qdi.add(b);
		qdi.save();
		System.out.println(qdi.getQuestion("1").getType());
	}
}

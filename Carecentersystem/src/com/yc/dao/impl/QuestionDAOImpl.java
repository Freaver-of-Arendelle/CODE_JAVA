package com.yc.dao.impl;

import java.io.File;
import java.util.List;
import java.util.Vector;

import com.yc.model.Question;
import com.yc.tool.UtilTool;

public class QuestionDAOImpl {
	List<Question> questions = new Vector<Question>();
	 String path;

	public QuestionDAOImpl() {
		path = "c:\\abc\\questions.txt";
		if (new File("c:\\abc\\questions.txt").length() != 0) {
			questions = (List<Question>) UtilTool
					.getObject(path);
		}
	}

	public void register(Question question) {
		questions.add(question);
		writeFile(path);
	}

	public void writeFile(String path) {
		UtilTool.save(path, questions);
	}

	public Vector<Question> query() {
		questions = (List<Question>) UtilTool.getObject(path);
		return (Vector<Question>) questions;
	}

	public Boolean delete(Question question) {
		Boolean flag = questions.remove(question);
		writeFile(path);
		return flag;
	}
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
		Question q= new Question();
		QuestionDAOImpl qdi =new QuestionDAOImpl();
		qdi.register(new Question(1,"½ñÌì¶ÍÁ¶ÁËÂð","1","2","3","A"));
		qdi.writeFile( "c:\\abc\\questions.txt");
	}
}

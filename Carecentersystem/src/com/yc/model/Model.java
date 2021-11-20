package com.yc.model;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;
//Ä£°åÎÊ¾í
public class Model implements Serializable {
	private int id;
	private String name;
	private String type;
	private Vector<Question> questions = new Vector<Question>();

	public Model() {

	}

	public Model(int id, String name, String type, Vector<Question> questions) {
		this.id = id;
		this.name = name;
		this.type = type;
		if (questions != null) {
			this.questions = questions;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public Vector<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Vector<Question> questions) {
		this.questions = questions;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public void addQuestion(Question question) {
//		this.questions.add(question);
//	}

	public Question getQuestion(String id) {
		Question ans = null;
		for (Question question : questions) {
			if (question.getId() == Integer.parseInt(id)) {
				ans = question;
			}
		}
		return ans;

	}
}

package com.zjm.model;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class QuestionModel implements Serializable{
	private int id;
	private String name;
	private String type; 
	
	private Vector<Question> questions;

	public QuestionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionModel(int id, String name, String type,
			Vector<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.questions = questions;
	}

	public QuestionModel(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.questions = new Vector<Question>();
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

	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	public Question getQuestion(String id){
		Question ans = null;
		for (Question question : questions) {
			if (question.getId()==Integer.parseInt(id)) {
				ans = question;
			}
		}
		return ans;
		
	}
}

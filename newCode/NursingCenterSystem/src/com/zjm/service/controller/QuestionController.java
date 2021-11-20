package com.zjm.service.controller;

import java.util.Vector;

import com.zjm.model.Question;


public interface QuestionController {
	public abstract Boolean add(Question question);
	public abstract Boolean delete(Question question);
	public abstract Vector<Question> query();
	public abstract Vector<String> getColNames();
	public abstract Boolean save();
	public abstract Question getQuestion(String id);
}

package com.zjm.dao.model;

import java.util.Vector;

import com.zjm.model.Question;


public interface QuestionDAO {
	public abstract void writeFile(String path);
	public abstract void add(Question question);
	public abstract Boolean delete(Question question);
	public abstract Vector<Question> query();
	public abstract Boolean save();
	public abstract Question getQuestion(String id);
}

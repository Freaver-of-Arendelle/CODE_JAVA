package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Question;

public interface QuestionDAO {
	public abstract Vector<Question> query();
	public abstract Boolean add(Question question);
	public abstract Boolean delete (Question question);
	public abstract void writeFile(String path);
}

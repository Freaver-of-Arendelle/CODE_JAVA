package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Question;

public interface QuestionController {
	public abstract Vector<Question> query();
	public abstract Boolean add(Question question);
	public abstract Boolean delete (Question question);
	public abstract Vector <String> getColnames();
}

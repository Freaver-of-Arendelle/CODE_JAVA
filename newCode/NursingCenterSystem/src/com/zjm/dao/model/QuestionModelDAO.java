package com.zjm.dao.model;

import java.util.Vector;

import com.zjm.model.QuestionModel;

public interface QuestionModelDAO {
	public abstract void writeFile(String path);
	public abstract void add(QuestionModel quesModel);
	public abstract Boolean delete(QuestionModel quesModel);
	public abstract Vector<QuestionModel> query();
	public abstract Boolean save();
	public abstract QuestionModel getQuesModel(String id);
}

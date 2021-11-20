package com.zjm.service.controller;

import java.util.Vector;
import com.zjm.model.QuestionModel;

public interface QuestionModelController {
	public abstract Boolean add(QuestionModel quesModel);
	public abstract Boolean delete(QuestionModel quesModel);
	public abstract Vector<QuestionModel> query();
	public abstract Vector<String> getColNames();
	public abstract Boolean save();
	public abstract QuestionModel getQuesModel(String id);
}

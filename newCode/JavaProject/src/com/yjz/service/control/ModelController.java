package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Model;
import com.yjz.model.Question;

public interface ModelController {
	public abstract Boolean delete(Model model);
	public abstract Boolean add(Model model);
	public abstract Vector<Model> query();
	public abstract Vector<String> getColNames();
	public abstract Vector<String> getScanColnames();
	public abstract Boolean delete(Model model,Question question);
	public abstract Boolean add(Model model,Question question);
}

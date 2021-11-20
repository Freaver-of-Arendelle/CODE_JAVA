package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Model;
import com.yjz.model.Question;

public interface ModelDAO {
	public abstract void writeFile(String path);
	public abstract Boolean delete(Model model);
	public abstract Boolean add(Model model);
	public abstract Vector<Model> query();
	public abstract Boolean delete(Model model,Question question);
	public abstract Boolean add(Model model,Question question);
}

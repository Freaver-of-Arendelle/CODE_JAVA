package com.yc.dao.impl;

import java.io.File;

import java.util.List;
import java.util.Vector;

import com.yc.model.Model;
import com.yc.model.Question;
import com.yc.tool.UtilTool;

public class ModelDAOImpl {
	// private static ModelDAOImpl instance =new ModelDAOImpl();
	private Vector<Model> models;
	private QuestionDAOImpl qdi;
	private String path;
	static int id = 1;

	public ModelDAOImpl() {
		qdi = new QuestionDAOImpl();
		models = new Vector<Model>();
		path = "c:\\abc\\models.txt";
		if (new File("c:\\abc\\models.txt").length() != 0) {
			models = (Vector<Model>) UtilTool.getObject(path);
		}
	}

	public void register(Model model) {
		model.setId(id);
		models.add(model);
		id++;
		writeFile(path);
	}

	public void writeFile(String path) {
		UtilTool.save(path, models);
	}

	public Vector<Model> query() {
		models = (Vector<Model>) UtilTool.getObject(path);
		return (Vector<Model>) models;
	}

	public Boolean delete(Model model) {
		Boolean flag = models.remove(model);
		writeFile(path);
		return flag;
	}

	public Model getModel(String id) {
		Model model = null;
		for (Model m : models) {
			if (m.getId() == Integer.parseInt(id)) {
				model = m;
				break;
			}
		}
		return model;
	}
	public static void main(String[] args) {
		Model m =new Model();
		ModelDAOImpl mdi= new ModelDAOImpl();
		Vector<Question> q=new Vector<Question>();
		q.add(new Question(1, "跑步了吗", "1000m", "500m","没有" , "A"));
		mdi.register(new Model(1,"运动卷","A",q) );
		mdi.writeFile("c:\\abc\\models.txt");
	}

}

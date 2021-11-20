package com.yjz.service.impl.control;

import java.util.Vector;

import com.yjz.dao.model.ModelDAO;
import com.yjz.impl.model.ModelDAOImpl;
import com.yjz.model.Model;
import com.yjz.model.Question;
import com.yjz.service.control.ModelController;

public class ModelControllerImpl implements ModelController {

	private static ModelDAO md = ModelDAOImpl.getinstance();
	private static ModelControllerImpl instance = new ModelControllerImpl();
	
	private ModelControllerImpl() {
		super();
	}

	public static ModelControllerImpl getinstance(){
		return instance;
	}
	
	@Override
	public Boolean delete(Model model) {
		return this.md.delete(model);
	}

	@Override
	public Boolean add(Model model) {
		return this.md.add(model);
	}

	@Override
	public Vector<Model> query() {
		return md.query();
	}

	@Override
	public Vector<String> getColNames() {
		Vector<String> colnames = new Vector<String>();
		colnames.add("");
		colnames.add("ID");
		colnames.add("题目");
		colnames.add("类型");
		return colnames;
	}
	@Override
	public Vector<String> getScanColnames() {
		Vector<String> scancolnames = new Vector<String>();
		scancolnames.add("");
		scancolnames.add("ID");
		scancolnames.add("题目");
		return scancolnames;
	}
	@Override	
	public Boolean delete(Model model, Question question) {
		return md.delete(model, question);
		}

	@Override
	public Boolean add(Model model, Question question) {
		return md.add(model, question);
	}
}

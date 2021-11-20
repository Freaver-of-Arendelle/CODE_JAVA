package com.yc.service.control;

import java.util.Vector;

import com.yc.dao.impl.ModelDAOImpl;
import com.yc.dao.impl.PatientDAOImpl;
import com.yc.model.Model;
import com.yc.model.Patient;

public class ModelServiceImpl {
	private ModelDAOImpl mdi;
	String path;

	public ModelServiceImpl() {
		mdi = new ModelDAOImpl();
		path = "c:\\abc\\models.txt";
	}

	public Boolean register(Model model) {
		Boolean flag = true;
		try {
			mdi.register(model);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public void save() {
		mdi.writeFile(path);
	}
	public Model getModel(String id) {
		return mdi.getModel(id);
	}

	public Vector<Vector<Object>> query() {
		Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
		Vector<Model> models = mdi.query();
		for (Model model : models) {
			Vector<Object> data = new Vector<Object>();
			data.add(new Boolean(false));
			data.add(model.getId());
			data.add(model.getName());
			data.add(model.getType());
			datas.add(data);
		}
		return datas;
	}

	public Vector<String> getcolNames() {
		Vector<String> cols = new Vector<String>();
		cols.add("");
		cols.add("ID");
		cols.add("题目");
		cols.add("类型");
		return cols;
	}

}

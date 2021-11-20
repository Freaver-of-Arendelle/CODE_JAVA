package com.yc.service.control;

import java.util.Vector;

import com.yc.dao.impl.HistoryDAOImpl;
import com.yc.dao.impl.ModelDAOImpl;
import com.yc.model.History;
import com.yc.model.Model;

public class HistoryServiceImpl {
	private HistoryDAOImpl hdi;
	String path;

	public HistoryServiceImpl() {
		hdi = new HistoryDAOImpl();
		path = "c:\\abc\\history.txt";
	}

	public void save() {
		hdi.writeFile(path);
	}

	public Vector<Vector<Object>> query() {
		Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
		Vector<History> histories = hdi.query();
		for (History history : histories) {
			Vector<Object> data = new Vector<Object>();
			data.add(history.getName());
			data.add(history.getGender());
			data.add(history.getModelName());
			data.add(history.getModelType());
			data.add(history.getTime());
			data.add(history.getEvaluatedBy());
			data.add(history.getAdvice());
			datas.add(data);
		}
		return datas;
	}
}

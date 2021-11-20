package com.zjm.dao.impl.model;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import com.zjm.dao.model.HistoryDAO;
import com.zjm.dao.tool.UtilTool;
import com.zjm.model.History;
import com.zjm.model.Question;
import com.zjm.model.QuestionModel;

public class HistoryDAOImpl implements HistoryDAO {

	private static HistoryDAOImpl instance = new HistoryDAOImpl();
	
	
	private Vector<History> histories;
	private String path;
	
	
	private HistoryDAOImpl() {
		histories = new Vector<History>();
		path = "e://abc//histories.txt";
		try {
			File file = new File(path);
			if (file.createNewFile()) {

			} else if (new File(path).length() != 0) {
				histories = (Vector<History>) UtilTool
						.getObjectBySerialize(path);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static HistoryDAOImpl getinstance(){
		return instance;
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, histories);


	}

	@Override
	public void add(History history) {
		this.histories.add(history);
		writeFile(path);

	}

	@Override
	public Boolean delete(History history) {
		Boolean flag = histories.remove(history);
		writeFile(path);
		return flag;
	}

	@Override
	public Vector<History> query() {
		return (Vector<History>) this.histories;
	}

	@Override
	public Boolean save() {
		writeFile(path);
		return null;
	}

}

package com.yc.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.yc.model.History;
import com.yc.model.Worker;
import com.yc.tool.UtilTool;

public class HistoryDAOImpl {
	List<History> histories;
	String path;

	public HistoryDAOImpl() {
		path = "c:\\abc\\history.txt";
		File file = new File(path);
		if (new File("c:\\abc\\history.txt").length() != 0) {
			histories = (List<History>) UtilTool.getObject(path);
		} else {
			histories = new Vector<History>();
		}

	}

	public void register(History history) {
		histories.add(history);
		writeFile(path);
	}

	public void writeFile(String path) {
		UtilTool.save(path, histories);
	}

	public Vector<History> query() {
		histories = (List<History>) UtilTool.getObject(path);
		return (Vector<History>) histories;
	}
public static void main(String[] args) {
	History h =new History();
	HistoryDAOImpl hdi= new HistoryDAOImpl();
	hdi.register(new History("张阿姨", "女", "运动卷","A" ,"20210720", "张三", "优秀"));
	hdi.writeFile("c:\\abc\\history.txt");
}
}

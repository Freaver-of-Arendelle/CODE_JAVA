package com.yc.dao.impl;

import java.io.File;
import java.util.List;
import java.util.Vector;

import com.yc.tool.UtilTool;
import com.yc.model.History;
import com.yc.model.Patient;
import com.yc.model.Worker;

public class WorkerDAOImpl {
	List<Worker> workers;
	String path;

	// 空参构造 初始化数据
	public WorkerDAOImpl() {
		path = "c:\\abc\\users.txt";
		// 避免出现Null异常
		if (new File("c:\\abc\\users.txt").length() != 0) {
			workers = (List<Worker>) UtilTool.getObject(path);
		} else {
			workers = new Vector<Worker>();
		}

	}

	public void register(Worker worker) {
		workers.add(worker);
		writeFile(path);
	}

	public void writeFile(String path) {
		UtilTool.save(path, workers);
	}

	public Boolean login(Worker worker) {
		Boolean flag = false;
		workers = (List<Worker>) UtilTool.getObject(path);
		for (Worker w : workers) {
			if (w.getAccount().equals(worker.getAccount())
					&& w.getPassword().equals(worker.getPassword())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public Vector<Worker> query() {
		workers = (List<Worker>) UtilTool.getObject(path);
		return (Vector<Worker>) workers;
	}

	public Boolean delete(Worker worker) {
		Boolean flag = workers.remove(worker);
		writeFile(path);
		return flag;
	}

	public static void main(String[] args) {
		Worker worker = new Worker();
		WorkerDAOImpl wdi = new WorkerDAOImpl();
		wdi.register(new Worker("1", "1", "zs", "张三", "19980806", "外科", "医生",
				"123"));
		wdi.writeFile("c:\\abc\\users.txt");
	}
}
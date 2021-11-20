package com.zjm.dao.impl.model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.zjm.dao.model.WorkerDAO;
import com.zjm.dao.tool.UtilTool;
import com.zjm.model.Patient;
import com.zjm.model.Worker;

public class WorkerDAOImpl implements WorkerDAO {

	private static WorkerDAOImpl instance = new WorkerDAOImpl();
	
	private Vector<Worker> workers;
	private String path;

	private WorkerDAOImpl() {
		workers = new Vector<Worker>();
		path = "e://abc//worker.txt";
		try {
			File file = new File(path);
			if (file.createNewFile()) {

			} else if (new File(path).length() != 0) {
				workers = (Vector<Worker>) UtilTool.getObjectBySerialize(path);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	public static WorkerDAOImpl getinstance(){
		return instance;
	}

	@Override
	public Boolean register(Worker worker) {
		Boolean flag = false;
		if (this.getWorker(worker.getAccount())==null) {			
			this.workers.add(worker);
			writeFile(path);
			flag = true;
		}
		return flag;
	}

	@Override
	public Vector<Worker> query() {
		return (Vector<Worker>) workers;
	}

	@Override
	public Boolean login(Worker worker) {
		Boolean flag = false;
		for (Worker wkr : workers) {
			if (wkr.getAccount().equals(worker.getAccount())
					&& wkr.getPassword().equals(worker.getPassword())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, workers);
	}

	public static void main(String[] args) {
		WorkerDAOImpl wdi = new WorkerDAOImpl();
		wdi.register(new Worker("ww", "555"));
		Boolean s = wdi.login(new Worker("ww", "555"));
		System.out.println(s);

	}

	@Override
	public Boolean delete(Worker worker) {
		Boolean flag = workers.remove(worker);
		writeFile(path);
		return flag;
	}

	@Override
	public Boolean save() {
		writeFile(path);
		return null;
	}

	@Override
	public Worker getWorker(String account) {
		Worker wk = null;
		for (Worker worker : workers) {
			if (worker.getAccount().equals(account)) {
				wk = worker;
				break;
			}
		}
		return wk;
	}
}

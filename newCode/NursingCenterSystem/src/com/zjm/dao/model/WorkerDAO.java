package com.zjm.dao.model;

import java.util.Vector;

import com.zjm.dao.tool.UtilTool;
import com.zjm.model.Worker;

public interface WorkerDAO {
	public abstract void writeFile(String path);
	public abstract Boolean login(Worker worker);
	public abstract Boolean register(Worker worker);
	public abstract Boolean delete(Worker worker);
	public abstract Vector<Worker> query();
	public abstract Boolean save();
	public abstract Worker getWorker(String account);
}

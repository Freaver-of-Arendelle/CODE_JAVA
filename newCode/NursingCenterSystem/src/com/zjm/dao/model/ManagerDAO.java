package com.zjm.dao.model;

import com.zjm.model.Manager;
import com.zjm.model.Worker;

public interface ManagerDAO {
	public abstract void writeFile(String path);
	public abstract Boolean login(Manager manager);
	public abstract void register(Manager manager);
}

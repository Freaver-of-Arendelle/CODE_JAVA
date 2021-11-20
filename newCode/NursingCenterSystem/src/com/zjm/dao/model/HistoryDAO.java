package com.zjm.dao.model;

import java.util.Vector;

import com.zjm.model.History;
import com.zjm.model.Question;

public interface HistoryDAO {
	public abstract void writeFile(String path);
	public abstract void add(History history);
	public abstract Boolean delete(History history);
	public abstract Vector<History> query();
	public abstract Boolean save();
}

package com.zjm.service.controller;

import java.util.Vector;

import com.zjm.model.History;



public interface HistoryController {
	public abstract Boolean add(History history);
	public abstract Boolean delete(History history);
	public abstract Vector<History> query();
	public abstract Vector<String> getColNames();
	public abstract Boolean save();
}

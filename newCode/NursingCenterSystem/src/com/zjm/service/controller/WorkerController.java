package com.zjm.service.controller;

import java.util.Vector;

import com.zjm.model.Worker;


public interface WorkerController {
	public abstract Boolean login(Worker worker);
	public abstract Boolean register(Worker worker);
	public abstract Boolean delete(Worker worker);
	public abstract Vector<Worker> query();
	public abstract Vector<String> getColNames();
	public abstract Boolean save();
	public abstract Worker getWorker(String account);
}

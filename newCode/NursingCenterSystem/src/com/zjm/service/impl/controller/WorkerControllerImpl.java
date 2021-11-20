package com.zjm.service.impl.controller;

import java.util.Vector;

import com.zjm.dao.impl.model.WorkerDAOImpl;
import com.zjm.dao.model.WorkerDAO;
import com.zjm.model.Worker;
import com.zjm.service.controller.WorkerController;

public class WorkerControllerImpl implements WorkerController {

	private static WorkerControllerImpl instance = new WorkerControllerImpl();
	
	private WorkerDAO workerDao;
	private WorkerControllerImpl() {
		workerDao = WorkerDAOImpl.getinstance();
	}
	
	public static WorkerControllerImpl getinstance(){
		return instance;
	}

	@Override
	public Boolean register(Worker worker) {
		Boolean flag = false;
		try {
			flag = workerDao.register(worker);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public Vector<Worker> query() {
		return workerDao.query();
	}

	@Override
	public Vector<String> getColNames() {
		Vector<String> colNames = new Vector<String>();
		colNames.add("");
		colNames.add("�û���");
		colNames.add("����");
		colNames.add("��������");
		colNames.add("ר��");
		colNames.add("ְ��");
		colNames.add("��ϵ�绰");
		return colNames;
	}

	@Override
	public Boolean login(Worker worker) {
		Boolean flag = workerDao.login(worker);
		return flag;
	}

	@Override
	public Boolean delete(Worker worker) {
		Boolean flag = workerDao.delete(worker);
		return flag;
	}

	@Override
	public Boolean save() {
		Boolean flag = false;
		flag = workerDao.save();
		return flag;
		
	}

	@Override
	public Worker getWorker(String account) {
		return workerDao.getWorker(account);
	}

}

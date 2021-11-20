package com.yc.service.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.yc.dao.impl.WorkerDAOImpl;

import com.yc.model.Worker;
import com.yc.tool.UtilTool;

public class WorkerServiceImpl {
	private WorkerDAOImpl wdi;
	private Vector<Worker> workers;
	String path;

	public WorkerServiceImpl() {
		wdi = new WorkerDAOImpl();
		path = "c:\\abc\\users.txt";
	}

	public String login(Worker worker) {
		return wdi.login(worker) ? "登陆成功" : "失败";
	}

	public Boolean register(Worker worker) {
		Boolean flag = true;
		try {
			wdi.register(worker);
			flag = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public void save() {
		wdi.writeFile(path);
	}
	public Vector<Worker> querynd() {
		workers = (Vector<Worker>) UtilTool.getObject(path);
		return (Vector<Worker>) workers;
	}
	public Vector<Vector<Object>> query() {
		Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
		Vector<Worker> workers = wdi.query();
		for (Worker worker : workers) {
			Vector<Object> data = new Vector<Object>();
			data.add(new Boolean(false));
			data.add(worker.getUsername());
			data.add(worker.getName());
			data.add(worker.getBirthday());
			data.add(worker.getStrength());
			data.add(worker.getPosition());
			data.add(worker.getPhone());
			datas.add(data);
		}
		return datas;
	}

	public Vector<String> getcolNames() {
		Vector<String> cols = new Vector<String>();
		cols.add("");
		cols.add("用户名");
		cols.add("姓名");
		cols.add("出生日期");
		cols.add("特长");
		cols.add("职称");
		cols.add("联系电话");

		return cols;
	}
}

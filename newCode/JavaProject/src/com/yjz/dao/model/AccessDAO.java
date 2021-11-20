package com.yjz.dao.model;

import java.util.Vector;

import com.yjz.model.Access;
import com.yjz.model.Admin;

public interface AccessDAO {
	public abstract Vector<Access> query();
	public abstract void writeFile(String path);
	public abstract Boolean login(Access access);
}

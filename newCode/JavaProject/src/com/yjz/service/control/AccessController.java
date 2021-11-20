package com.yjz.service.control;

import java.util.Vector;

import com.yjz.model.Access;

public interface AccessController {
	public abstract Vector<Access> query();
	public abstract Vector<String> getColnames();
	public abstract Boolean login(Access access);
}

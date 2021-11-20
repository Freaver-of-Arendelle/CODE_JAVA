package com.yjz.dao.model;

import com.yjz.model.MaxAdmin;

public interface MaxAdminDAO {

	public abstract void register(MaxAdmin maxadmin);
	public abstract void writeFile(String path);
	public abstract Boolean login(MaxAdmin maxadmin);
	
}

package com.yjz.service.control;

import com.yjz.model.MaxAdmin;

public interface MaxAdminController {
	/**
	 * 
	 * @param maxadmin 匹配对象
	 * @return 成功与否
	 */
	public abstract Boolean login(MaxAdmin maxadmin);
	
}

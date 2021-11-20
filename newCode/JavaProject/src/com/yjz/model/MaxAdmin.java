package com.yjz.model;

import java.io.Serializable;

public class MaxAdmin implements Serializable //π‹¿Ì‘±
{

	private String account;
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MaxAdmin(String account, String password) {
		
		this.account = account;
		this.password = password;
	}

	public MaxAdmin() {
		
	}

}

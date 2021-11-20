package com.zjm.model;

import java.io.Serializable;

public class Manager implements Serializable{
	private String account;
	private String password;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

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

}

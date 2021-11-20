package com.yc.model;
//管理人员
public class Manager implements java.io.Serializable {
	private String account ;
	private String password ;

	public Manager() {
		super();
	}

	public Manager(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public String getPassword() {
		return password;
	}

}

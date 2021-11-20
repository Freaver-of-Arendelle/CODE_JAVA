package com.yjz.model;

import java.io.Serializable;

public class Admin implements Serializable
//工作人员信息
{

	private String account;
	private String password;
	private String userName;
	private String realName;
	private String birth;
	private String major;
	private String job;
	private String phone;

	public Admin() {
		
	}
	/**
	 * 
	 * @param account String 账户
	 * @param password String 密码
	 * @param userName String 用户名
	 * @param realName String 姓名
	 * @param birth String 出生日期
	 * @param major String 专长
	 * @param job String 职称
	 * @param phone String 联系电话
	 */
	public Admin(String account, String password, String userName,
			String realName, String birth, String major, String job,
			String phone) {
		
		this.account = account;
		this.password = password;
		this.userName = userName;
		this.realName = realName;
		this.birth = birth;
		this.major = major;
		this.job = job;
		this.phone = phone;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

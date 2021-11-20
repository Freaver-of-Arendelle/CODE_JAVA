package com.yjz.model;

import java.io.Serializable;

public class Admin implements Serializable
//������Ա��Ϣ
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
	 * @param account String �˻�
	 * @param password String ����
	 * @param userName String �û���
	 * @param realName String ����
	 * @param birth String ��������
	 * @param major String ר��
	 * @param job String ְ��
	 * @param phone String ��ϵ�绰
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

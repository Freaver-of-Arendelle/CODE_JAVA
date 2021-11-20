package com.yc.model;

//������Ա
public class Worker implements java.io.Serializable {
	private String username;
	private String name;
	private String birthday;
	private String strength;
	private String position;
	private String phone;
	private String password;
	private String account;

	public Worker() {
		super();
	}
//�����˺ź�����Ĺ��췽�����Ա����ڹ������ע��
	public Worker(String account, String password) {
		this.account = account;
		this.password = password;
	}
//������Ա��Ϣ�Ĺ��죬�Ա����ڹ��������޸���Ϣ
	public Worker(String username, String name, String birthday,
			String strength, String position, String phone) {
		super();
		this.username = username;
		this.name = name;
		this.birthday = birthday;
		this.strength = strength;
		this.position = position;
		this.phone = phone;
	}
	public Worker(String account, String password,String username, String name, String birthday,
			String strength, String position, String phone) {
		super();
		this.account = account;
		this.password = password;
		this.username = username;
		this.name = name;
		this.birthday = birthday;
		this.strength = strength;
		this.position = position;
		this.phone = phone;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return 1;
	}

}

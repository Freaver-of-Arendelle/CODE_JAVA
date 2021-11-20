package com.yjz.model;

import java.io.Serializable;
import java.util.Vector;
//模板
public class Model implements Serializable{
	private String ID;
	private String title;
	private String form;
	private Vector <Question> qinm= new Vector <Question>(); 

	public Vector<Question> getQinm() {
		return qinm;
	}

	public void setQinm(Vector<Question> qinm) {
		this.qinm = qinm;
	}

	public Model() {

	}

	/**
	 * 
	 * @param iD String 模板ID
	 * @param title String 模板题目
	 * @param form String 模板类型
	 */
	public Model(String iD, String title, String form) {

		ID = iD;
		this.title = title;
		this.form = form;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

}

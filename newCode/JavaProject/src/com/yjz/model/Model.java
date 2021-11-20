package com.yjz.model;

import java.io.Serializable;
import java.util.Vector;

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

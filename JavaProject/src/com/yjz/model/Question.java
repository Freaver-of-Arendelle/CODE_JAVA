package com.yjz.model;

import java.io.Serializable;

public class Question implements Serializable {

	private String ID;
	private String question;
	private String form;
	private String answer1;
	private String answer2;
	private String answer3;
	/**
	 * 
	 * @param iD String 问题ID
	 * @param question String 问题题目  
	 * @param form String 问题类型
	 * @param answer1 String 答案一
	 * @param answer2 String 答案二
	 * @param answer3 String 答案三
	 */
	public Question(String iD, String question, String form, String answer1,
			String answer2, String answer3) {

		ID = iD;
		this.question = question;
		this.form = form;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}

	public Question() {

	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

}

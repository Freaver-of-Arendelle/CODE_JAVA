package com.yc.model;

import java.io.Serializable;
//评估后的数据放这里
public class History implements Serializable {
	private String name;
	private String gender;
	private String modelName;
	private String modelType;
	private String time;
	private String evaluatedBy;
	private String advice;

	public History() {

	}

	public History(String name, String gender, String modelName,
			String modelType, String time, String evaluatedBy, String advice) {
		super();
		this.name = name;
		this.gender = gender;
		this.modelName = modelName;
		this.modelType = modelType;
		this.time = time;
		this.evaluatedBy = evaluatedBy;
		this.advice = advice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEvaluatedBy() {
		return evaluatedBy;
	}

	public void setEvaluatedBy(String evaluatedBy) {
		this.evaluatedBy = evaluatedBy;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}
}
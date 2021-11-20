package com.zjm.dao.impl.model;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import com.zjm.dao.model.QuestionModelDAO;
import com.zjm.dao.tool.UtilTool;
import com.zjm.model.Question;
import com.zjm.model.QuestionModel;

public class QuestionModelDAOImpl implements QuestionModelDAO {
	
	private static QuestionModelDAOImpl instance = new QuestionModelDAOImpl();
	
	private Vector<QuestionModel> quesModels;
	private String path;
	private QuestionDAOImpl qdi = QuestionDAOImpl.getinstance();
	
	private QuestionModelDAOImpl() {
		quesModels = new Vector<QuestionModel>();
		path = "e://abc//quesModel.txt";
		try {
			File file = new File(path);
			if (file.createNewFile()) {

			} else if (new File(path).length() != 0) {
				quesModels = (Vector<QuestionModel>) UtilTool.getObjectBySerialize(path);
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static QuestionModelDAOImpl getinstance(){
		return instance;
	}
	
	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, quesModels);
	}

	@Override
	public void add(QuestionModel quesModel) {
		this.quesModels.add(quesModel);
		writeFile(path);

	}

	@Override
	public Boolean delete(QuestionModel quesModel) {
		Boolean flag = quesModels.remove(quesModel);
		writeFile(path);
		return flag;
	}

	@Override
	public Vector<QuestionModel> query() {
		return this.quesModels;
	}

	@Override
	public Boolean save() {
		QuestionModel qm = null;
		Question ques = null;
		for (int i = 0; i < quesModels.size(); i++) {
			qm = quesModels.get(i);
			for (int j = 0; j < qm.getQuestions().size(); j++) {
				ques = qm.getQuestions().get(j);
				if (qdi.getQuestion(String.valueOf(ques.getId()))==null) {
					qm.getQuestions().remove(ques);
				}
			}
			
		}
		writeFile(path);
		return null;
	}

	@Override
	public QuestionModel getQuesModel(String id) {
		QuestionModel quesModel = null;
		for (QuestionModel qsm : quesModels) {
			if (qsm.getId()==Integer.parseInt(id)) {
				quesModel = qsm;
				break;
			}
		}
		return quesModel;
	}
	public static void main(String[] args) {
		Question a = new Question();
		Question b = new Question();
		Vector<Question> ques = new Vector<Question>();
		ques.add(a);
		ques.add(b);
		QuestionModel c = new QuestionModel(1, "a", "A", ques);
		QuestionModelDAOImpl dao= new QuestionModelDAOImpl();
		dao.add(c);
		c = new QuestionModel(2, "b", "C", ques);
		dao.add(c);
		dao.save();
	}
}

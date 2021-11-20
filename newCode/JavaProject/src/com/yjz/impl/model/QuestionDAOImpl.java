package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.QuestionDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.Question;

public class QuestionDAOImpl implements QuestionDAO{

	Vector <Question> question = new Vector<Question>();
	
	public QuestionDAOImpl(){
		File f = new File("c://abc//Question.txt");
		if(f.length()!=0){
			this.question = (Vector<Question>) UtilTool.getFileBySerialize("c://abc//Question.txt");
		}else{
			JOptionPane.showMessageDialog(null, "�޷��ҵ��ļ�");
		}
	}
	
	@Override
	public Vector<Question> query() {
		return question;
	}

	@Override
	public Boolean add(Question question) {
		Boolean flag = false;
		try{
			this.question.add(question);
			writeFile("c://abc//Question.txt");
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public Boolean delete(Question question) {
		Boolean flag =false;
		try{
			this.question.remove(question);
			writeFile("c://abc//Question.txt");
			flag=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, question);
	}

//	public static void main(String[] args) {
//		Question q1 = new Question("1","uzi������","A","��ȫ����","�ӽ���","����");
//		Question q2 = new Question("2","¬��ΰ��û�п���","B","û��","����","��֪��");
//		Question q3 = new Question("3","��С���ӹ��ò�����ձ����̵�һ��","A","�˷�ˮ","������ŵ","�̲�");
//		Question q4 = new Question("4","���ţ����","C","ţ��","�ǳ�ţ��","�ǳ��ǳ�ţ��");
//		Question q5 = new Question("5","RNG�������߶�Զ","A","��ԵS��","S����̭��","S���ھ�");
//		Question q6 = new Question("6","����ѡ������һ����Ŀǰ���۹����е�","B","Xiaohu","Doinb","Knight");
//		Question q7 = new Question("7","��΢Цʱ�����ĵ���ô��","C","����","�����е�����","��fuck˵");
//		Question q8 = new Question("8","��������ͨ��˵�Ľ�ʥ����Ϸ�е�������ʲô","A","�������","�޼���ʥ","����");
//		Question q9 = new Question("9","������˵�İ�����������ʲô","A","�������� ������ҫ TES","��Ϊ ս�� RNG","���� ԭ�� WE");
//		QuestionDAOImpl qd = new QuestionDAOImpl();
//		qd.add(q1);qd.add(q2);qd.add(q3);
//		qd.add(q4);qd.add(q5);qd.add(q6);
//		qd.add(q7);qd.add(q8);qd.add(q9);
//		
//	}
	
	
}

package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.QuestionDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.Question;

public class QuestionDAOImpl implements QuestionDAO{
	private static QuestionDAOImpl instance = new QuestionDAOImpl();
	
	Vector <Question> question = new Vector<Question>();
	
	private QuestionDAOImpl(){
		File f = new File("c://abc//Question.txt");
		if(f.length()!=0){
			this.question = (Vector<Question>) UtilTool.getFileBySerialize("c://abc//Question.txt");
		}else{
			JOptionPane.showMessageDialog(null, "无法找到文件");
		}
	}
	public static QuestionDAOImpl getinstance(){
		return instance;
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
//		Question q1 = new Question("1","uzi是神吗","A","完全符合","接近神","不是");
//		Question q2 = new Question("2","卢本伟有没有开挂","B","没有","开了","不知道");
//		Question q3 = new Question("3","给小日子过得不错的日本阿姨倒一杯","A","核废水","卡布奇诺","绿茶");
//		Question q4 = new Question("4","臧佬牛逼吗","C","牛逼","非常牛逼","非常非常牛逼");
//		Question q5 = new Question("5","RNG今年能走多远","A","无缘S赛","S赛淘汰赛","S赛冠军");
//		Question q6 = new Question("6","下列选手中哪一个是目前现役国产中单","B","Xiaohu","Doinb","Knight");
//		Question q7 = new Question("7","你微笑时很美拍的怎么样","C","垃圾","垃圾中的垃圾","无fuck说");
//		Question q8 = new Question("8","请问我们通常说的剑圣在游戏中的名称是什么","A","宫本武藏","无极剑圣","主宰");
//		Question q9 = new Question("9","我们所说的爱国三件套是什么","A","哔哩哔哩 王者荣耀 TES","华为 战狼 RNG","抖音 原神 WE");
//		QuestionDAOImpl qd = new QuestionDAOImpl();
//		qd.add(q1);qd.add(q2);qd.add(q3);
//		qd.add(q4);qd.add(q5);qd.add(q6);
//		qd.add(q7);qd.add(q8);qd.add(q9);
//		
//	}
	
	
}

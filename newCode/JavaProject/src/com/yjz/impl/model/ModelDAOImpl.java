package com.yjz.impl.model;

import java.io.File;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.yjz.dao.model.ModelDAO;
import com.yjz.dao.tool.UtilTool;
import com.yjz.model.Model;
import com.yjz.model.Question;

public class ModelDAOImpl implements ModelDAO{

	Vector<Model> model = new Vector<Model>();
	
	public ModelDAOImpl(){
		File f = new File("c://abc//Model.txt");
		if(f.length()!=0){
			model=(Vector<Model>) UtilTool.getFileBySerialize("c://abc//Model.txt");
		}else{
			JOptionPane.showMessageDialog(null, "无法找到文件");
		}
		
	}
	
	@Override
	public void writeFile(String path) {
		UtilTool.saveFileBySerialize(path, model);
	}

	@Override
	public Boolean delete(Model model) {
		Boolean flag = false;
		try{
			this.model.remove(model);
			writeFile("c://abc//Model.txt");
			flag=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public Boolean add(Model model) {
		Boolean flag = false;
		try{
			this.model.add(model);
			writeFile("c://abc//Model.txt");
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public Vector<Model> query() {
		return model;
	}
	@Override
	public Boolean delete(Model model, Question question) {
		Boolean flag = false;
		try{
			for (Model mod : this.model) {
			if(model.equals(mod)){
				Model temp = mod;
				int tempindex=this.model.indexOf(temp);
				for (int i = 0; i < temp.getQinm().size(); i++) {
					if(question.equals(temp.getQinm().get(i))){
						this.model.get(tempindex).getQinm().remove(i);
						break;
					}
				}
				break;
			}
		}
		writeFile("c://abc//Model.txt");
		flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	@Override
	public Boolean add(Model model, Question question) {
		Boolean flag = false;
		try{
			for (Model mod : this.model) {
				if(model.equals(mod)){
					System.out.println("rngnb");
					mod.getQinm().add(question);
					writeFile("c://abc//Model.txt");
					flag = true;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
//	public static void main(String[] args) {
//		ModelDAOImpl mdi =new ModelDAOImpl();
//		Model model1 = new Model("1","模板一","A");
//		Model model2 = new Model("2","模板二","B");
//		Model model3 = new Model("3","模板三","C");
//		Vector<Question> vq1 = new Vector<Question>();
//		Vector<Question> vq2 = new Vector<Question>();
//		Vector<Question> vq3 = new Vector<Question>();
//		Question q1 = new Question("1","uzi是神吗","A","完全符合","接近神","不是");
//		Question q2 = new Question("2","卢本伟有没有开挂","B","没有","开了","不知道");
//		Question q3 = new Question("3","给小日子过得不错的日本阿姨倒一杯","A","核废水","卡布奇诺","绿茶");
//		Question q4 = new Question("4","臧佬牛逼吗","C","牛逼","非常牛逼","非常非常牛逼");
//		Question q5 = new Question("5","RNG今年能走多远","A","无缘S赛","S赛淘汰赛","S赛冠军");
//		Question q6 = new Question("6","下列选手中哪一个是目前现役国产中单","B","Xiaohu","Doinb","Knight");
//		Question q7 = new Question("7","你微笑时很美拍的怎么样","C","垃圾","垃圾中的垃圾","无fuck说");
//		Question q8 = new Question("8","请问我们通常说的剑圣在游戏中的名称是什么","A","宫本武藏","无极剑圣","主宰");
//		Question q9 = new Question("9","我们所说的爱国三件套是什么","A","哔哩哔哩 王者荣耀 TES","华为 战狼 RNG","抖音 原神 WE");
//		vq1.add(q1);vq1.add(q2);vq1.add(q3);
//		vq2.add(q4);vq2.add(q5);vq2.add(q6);
//		vq3.add(q7);vq3.add(q8);vq3.add(q9);
//		model1.setQinm(vq1);
//		model2.setQinm(vq2);
//		model3.setQinm(vq3);
//		mdi.add(model1);
//		mdi.add(model2);
//		mdi.add(model3);
//		
//	}
	
}

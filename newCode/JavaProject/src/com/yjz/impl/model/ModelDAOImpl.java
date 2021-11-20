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
			JOptionPane.showMessageDialog(null, "�޷��ҵ��ļ�");
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
//		Model model1 = new Model("1","ģ��һ","A");
//		Model model2 = new Model("2","ģ���","B");
//		Model model3 = new Model("3","ģ����","C");
//		Vector<Question> vq1 = new Vector<Question>();
//		Vector<Question> vq2 = new Vector<Question>();
//		Vector<Question> vq3 = new Vector<Question>();
//		Question q1 = new Question("1","uzi������","A","��ȫ����","�ӽ���","����");
//		Question q2 = new Question("2","¬��ΰ��û�п���","B","û��","����","��֪��");
//		Question q3 = new Question("3","��С���ӹ��ò�����ձ����̵�һ��","A","�˷�ˮ","������ŵ","�̲�");
//		Question q4 = new Question("4","���ţ����","C","ţ��","�ǳ�ţ��","�ǳ��ǳ�ţ��");
//		Question q5 = new Question("5","RNG�������߶�Զ","A","��ԵS��","S����̭��","S���ھ�");
//		Question q6 = new Question("6","����ѡ������һ����Ŀǰ���۹����е�","B","Xiaohu","Doinb","Knight");
//		Question q7 = new Question("7","��΢Цʱ�����ĵ���ô��","C","����","�����е�����","��fuck˵");
//		Question q8 = new Question("8","��������ͨ��˵�Ľ�ʥ����Ϸ�е�������ʲô","A","�������","�޼���ʥ","����");
//		Question q9 = new Question("9","������˵�İ�����������ʲô","A","�������� ������ҫ TES","��Ϊ ս�� RNG","���� ԭ�� WE");
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

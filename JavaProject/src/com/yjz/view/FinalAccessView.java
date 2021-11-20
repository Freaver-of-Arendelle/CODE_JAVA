package com.yjz.view;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.yjz.model.Access;
import com.yjz.model.Admin;
import com.yjz.model.Model;
import com.yjz.model.Patient;
import com.yjz.model.Question;
import com.yjz.service.impl.control.AccessControllerImpl;
import com.yjz.service.impl.control.ModelControllerImpl;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class FinalAccessView extends javax.swing.JFrame {
	private JScrollPane jspShow;
	private JButton btnSubmit;
	private JButton btnBack;
	private JPanel jp;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private Model mod;
	private Admin admin;
	private Patient pat;
	private AccessControllerImpl aci;
	public FinalAccessView(Model mod,Admin admin,Patient pat,AccessControllerImpl aci) {
		this.mod = mod;
		this.admin = admin;
		this.pat = pat;
		this.aci = aci;
		bg = new ButtonGroup[mod.getQinm().size()];//生成按钮组的个数与模板内问题的数量相同
		initGUI();
	}
	private ButtonGroup[] bg ;
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jspShow = new JScrollPane();
				getContentPane().add(jspShow);
				jspShow.setBounds(12, 25, 358, 267);
				{
					jp = new JPanel();
					jp.setLayout(new BoxLayout(jp,  BoxLayout.Y_AXIS));
					jspShow.setViewportView(jp);
				}
			}
			{
				btnSubmit = new JButton();
				getContentPane().add(btnSubmit);
				btnSubmit.setText("\u63d0\u4ea4");
				btnSubmit.setBounds(67, 318, 71, 27);
				btnSubmit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSubmitActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(210, 318, 71, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{	JLabel[] js = new JLabel[mod.getQinm().size()];//问题的个数与标签数目相同
				
				Question tempQues = null;
				for (int i = 0; i < bg.length; i++) {
				
					tempQues = mod.getQinm().get(i);
					bg[i] = new ButtonGroup();
					js[i] = new JLabel(tempQues.getQuestion());
					js[i].setBounds(0, 30*(i+1), 150, 50);
					jp.add(js[i]);
					
					JRadioButton[] jrbs = new JRadioButton[3];//每个问题下设置了三个选项
					jrbs[0] = new JRadioButton();//实例化第一个单选按钮
					jrbs[0].setBounds(0, 60*(i+1), 100, 50);//设置位置及大小
					jrbs[0].setText(tempQues.getAnswer1());
					jrbs[0].setActionCommand("A"+i);
					//将单选按钮加入到第一组中
					bg[i].add(jrbs[0]);
					//将单选按钮加入到窗口中
					jp.add(jrbs[0]);
					
					jrbs[1] = new JRadioButton();
					jrbs[1].setBounds(0, 90*(i+1), 100, 50);
					jrbs[1].setText(tempQues.getAnswer2());
					jrbs[1].setActionCommand("B"+i);
					bg[i].add(jrbs[1]);
					jp.add(jrbs[1]);
					
					jrbs[2] = new JRadioButton();
					jrbs[2].setBounds(0, 120*(i+1), 100, 50);
					jrbs[2].setText(tempQues.getAnswer3());
					jrbs[2].setActionCommand("C"+i);
					bg[i].add(jrbs[2]);
					jp.add(jrbs[2]);
				}
			}
			pack();
			this.setSize(400, 415);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private void btnSubmitActionPerformed(ActionEvent evt) {
//		System.out.println(pat.getName());
//		System.out.println(admin.getRealName());
//		System.out.println(mod.getTitle());
		Access ac = new Access();
		ac.setPatient(pat.getName());
		ac.setGender(pat.getGender());
		ac.setModel(mod.getTitle());
		ac.setModelform(mod.getForm());
		ac.setTime(new Date());//生成现在时间
		ac.setAccessman(admin.getRealName());
		char c;
		int score = 0;
		for (int i = 0; i < bg.length; i++) {
			c = bg[i].getSelection().getActionCommand().toCharArray()[0];
			if(c=='A'){
				score += 5;
			}else if(c=='B'){
				score += 3;
			}else if(c=='C'){
				score += 1;
			}
		}
		
		if(score>=0&&score<=5){
			ac.setAdvice("好");
		}
		if(score>5&&score<=10){
			ac.setAdvice("很好");
		}
		if(score>10&&score<=15){
			ac.setAdvice("非常好");
		}
		JOptionPane.showMessageDialog(null, "您的得分是"+score);
		aci.register(ac);
	}	
	
	private void btnBackActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
}		

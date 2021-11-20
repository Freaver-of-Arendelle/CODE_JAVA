package com.zjm.view;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zjm.model.History;
import com.zjm.model.Patient;
import com.zjm.model.Question;
import com.zjm.model.QuestionModel;
import com.zjm.model.Worker;
import com.zjm.service.impl.controller.HistoryControllerImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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
public class TestFrame extends javax.swing.JFrame {
	private JScrollPane jspShow;
	private JButton btnSubmit;
	private JButton btnBack;
	private JPanel jp;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private QuestionModel qm;	
	private Patient p;
	private Worker currWorker;
	private HistoryControllerImpl hci = HistoryControllerImpl.getinstance();
	public TestFrame(QuestionModel qm,Patient p,Worker currWorker) {
		super();
		this.qm = qm;
		this.p = p;
		this.currWorker = currWorker;
		bgs = new ButtonGroup[qm.getQuestions().size()];
		initGUI();
	}
	private ButtonGroup[] bgs ;
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
			{	JLabel[] js = new JLabel[qm.getQuestions().size()];
				
				Question tempQues = null;
				for (int i = 0; i < bgs.length; i++) {
				
					tempQues = qm.getQuestions().get(i);
					bgs[i] = new ButtonGroup();
					js[i] = new JLabel(tempQues.getQuestion());
					js[i].setBounds(0, 30*(i+1), 150, 50);
					jp.add(js[i]);
					
					JRadioButton[] jrbs = new JRadioButton[3];
					jrbs[0] = new JRadioButton();//实例化第一个单选按钮
					jrbs[0].setBounds(0, 60*(i+1), 100, 50);//设置位置及大小
					jrbs[0].setText(tempQues.getOptionA());
					jrbs[0].setActionCommand("A"+i);
					//将单选按钮加入到第一组中
					bgs[i].add(jrbs[0]);
					//将单选按钮加入到窗口中
					jp.add(jrbs[0]);
					
					jrbs[1] = new JRadioButton();
					jrbs[1].setBounds(0, 90*(i+1), 100, 50);
					jrbs[1].setText(tempQues.getOptionB());
					jrbs[1].setActionCommand("B"+i);
					bgs[i].add(jrbs[1]);
					jp.add(jrbs[1]);
					
					jrbs[2] = new JRadioButton();
					jrbs[2].setBounds(0, 120*(i+1), 100, 50);
					jrbs[2].setText(tempQues.getOptionC());
					jrbs[2].setActionCommand("C"+i);
					bgs[i].add(jrbs[2]);
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
		int score = 0;
		char op;
		for (int i = 0; i < bgs.length; i++) {
			op = bgs[i].getSelection().getActionCommand().toCharArray()[0];
			if (op=='A') {
				score += 5;
			}else if (op=='B') {
				score += 3;
			}else if (op=='C') {
				score += 1;
			}
			
		}
		Date dNow = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    
	    String advice = "";
	    if (score > bgs.length*3) {
			advice = "整挺好";
		}else if (score > bgs.length*2) {
			advice = "还算ok";
		}else if (score >= bgs.length) {
			advice = "不怎么样哦";
		}
		History result = new History(p.getName(), p.getGender(), qm.getName(), qm.getType(), ft.format(dNow), currWorker.getRealname(),advice);
		hci.add(result);
		EvaluateFrame ef = new EvaluateFrame(p,currWorker);
		ef.setLocationRelativeTo(null);
		ef.setVisible(true);
		this.dispose();
	}
	
	private void btnBackActionPerformed(ActionEvent evt) {
		EvaluateFrame ef = new EvaluateFrame(p,currWorker);
		ef.setLocationRelativeTo(null);
		ef.setVisible(true);
		this.dispose();
	}

}

package com.zjm.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zjm.model.Question;
import com.zjm.model.QuestionModel;
import com.zjm.service.impl.controller.QuestionControllerImpl;
import com.zjm.service.impl.controller.QuestionModelControllerImpl;


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
public class QuesAddFrame extends javax.swing.JFrame {
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton btnBack;
	private JButton btnSave;
	private JTextField txtType;
	private JTextField txtOptC;
	private JTextField txtOptB;
	private JTextField txtOptA;
	private JTextField txtQues;
	private JLabel jLabel6;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private QuestionControllerImpl qci;
	private QuestionModel qm;
	private QuestionModelControllerImpl qmci;
	private Integer count;
	public QuesAddFrame(QuestionModel qm) {
		super();
		this.qci = QuestionControllerImpl.getinstance();
		this.qm = qm;
		this.qmci = QuestionModelControllerImpl.getinstance();
		this.count = 0;
		for (Question qs : qci.query()) {
			if(qs.getId()>count){
				count = qs.getId();
			}
		}
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u95ee\u9898");
				jLabel2.setBounds(56, 37, 51, 21);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9009\u9879A");
				jLabel3.setBounds(56, 76, 51, 21);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u9009\u9879B");
				jLabel4.setBounds(58, 115, 51, 21);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u9009\u9879C");
				jLabel5.setBounds(56, 154, 51, 21);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u7c7b\u578b");
				jLabel6.setBounds(56, 193, 51, 21);
			}
			{
				txtQues = new JTextField();
				getContentPane().add(txtQues);
				txtQues.setBounds(114, 34, 187, 27);
			}
			{
				txtOptA = new JTextField();
				getContentPane().add(txtOptA);
				txtOptA.setBounds(115, 73, 187, 27);
			}
			{
				txtOptB = new JTextField();
				getContentPane().add(txtOptB);
				txtOptB.setBounds(115, 112, 187, 27);
			}
			{
				txtOptC = new JTextField();
				getContentPane().add(txtOptC);
				txtOptC.setBounds(114, 151, 187, 27);
			}
			{
				txtType = new JTextField();
				getContentPane().add(txtType);
				txtType.setBounds(114, 190, 187, 27);
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(107, 244, 65, 27);
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSaveActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(220, 244, 65, 27);
			}
			pack();
			this.setSize(400, 354);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void btnSaveActionPerformed(ActionEvent evt) {
		Question ques = new Question(count+1, txtQues.getText(), 
				txtOptA.getText(), txtOptB.getText(), txtOptC.getText(), txtType.getText());
		qci.add(ques);
		qci.save();
		QuestionListFrame qlf = new QuestionListFrame(qm);
		qlf.setLocationRelativeTo(null);
		qlf.setVisible(true);
		this.dispose();
	}

}

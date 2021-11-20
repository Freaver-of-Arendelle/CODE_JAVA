package com.zjm.view;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;

import com.zjm.model.Question;


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
public class QuesDetailFrame extends javax.swing.JFrame {
	private JLabel lblID;
	private JLabel lblQues;
	private JLabel lblAnsB;
	private JLabel lblAnsC;
	private JLabel lblAnsA;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private Question question;
	public QuesDetailFrame(Question question) {
		super();
		this.question = question;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				lblID = new JLabel();
				getContentPane().add(lblID);
				lblID.setBounds(12, 12, 77, 29);
				lblID.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				lblQues = new JLabel();
				getContentPane().add(lblQues);
				lblQues.setBounds(12, 53, 243, 29);
				lblQues.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u9009\u9879A");
				jLabel1.setBounds(12, 103, 41, 29);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u9009\u9879B");
				jLabel2.setBounds(12, 143, 39, 29);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9009\u9879C");
				jLabel3.setBounds(12, 188, 40, 29);
			}
			{
				lblAnsA = new JLabel();
				getContentPane().add(lblAnsA);
				lblAnsA.setBounds(71, 103, 286, 29);
				lblAnsA.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				lblAnsB = new JLabel();
				getContentPane().add(lblAnsB);
				lblAnsB.setBounds(69, 143, 288, 29);
				lblAnsB.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				lblAnsC = new JLabel();
				getContentPane().add(lblAnsC);
				lblAnsC.setBounds(71, 188, 286, 29);
				lblAnsC.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
			}
			{
				lblID.setText(String.valueOf(question.getId()));
				lblQues.setText(question.getQuestion());
				lblAnsA.setText(question.getOptionA());
				lblAnsB.setText(question.getOptionB());
				lblAnsC.setText(question.getOptionC());
			}
			pack();
			this.setSize(400, 321);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}

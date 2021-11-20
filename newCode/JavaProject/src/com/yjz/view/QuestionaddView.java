package com.yjz.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yjz.model.Question;
import com.yjz.service.impl.control.QuestionControllerImpl;


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
public class QuestionaddView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField jtxttitle;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton jbtpass;
	private JTextField jtxtanswer3;
	private JLabel jLabel6;
	private JTextField jtxtanswer2;
	private JTextField jtxtanswer1;
	private JTextField jtxtform;
	private JTextField jtxtid;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private QuestionControllerImpl qci;
	public QuestionaddView(QuestionControllerImpl qci) {
		this.qci=qci;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("ID");
				jLabel1.setBounds(12, 19, 32, 20);
			}
			{
				jtxtid = new JTextField();
				getContentPane().add(jtxtid);
				jtxtid.setBounds(43, 16, 54, 27);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u7c7b\u578b");
				jLabel2.setBounds(149, 19, 57, 20);
			}
			{
				jtxtform = new JTextField();
				getContentPane().add(jtxtform);
				jtxtform.setBounds(197, 19, 45, 27);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u9898\u76ee");
				jLabel3.setBounds(12, 67, 30, 20);
			}
			{
				jtxttitle = new JTextField();
				getContentPane().add(jtxttitle);
				jtxttitle.setBounds(54, 64, 245, 27);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u7b54\u6848\u4e00");
				jLabel4.setBounds(12, 115, 45, 20);
			}
			{
				jtxtanswer1 = new JTextField();
				getContentPane().add(jtxtanswer1);
				jtxtanswer1.setBounds(75, 112, 229, 27);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u7b54\u6848\u4e8c");
				jLabel5.setBounds(12, 157, 45, 20);
			}
			{
				jtxtanswer2 = new JTextField();
				getContentPane().add(jtxtanswer2);
				jtxtanswer2.setBounds(75, 157, 229, 27);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u7b54\u6848\u4e09");
				jLabel6.setBounds(12, 201, 45, 20);
			}
			{
				jtxtanswer3 = new JTextField();
				getContentPane().add(jtxtanswer3);
				jtxtanswer3.setBounds(75, 201, 229, 27);
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u786e\u5b9a");
				jbtpass.setBounds(130, 256, 92, 27);
				jbtpass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtpassActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(391, 357);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jbtpassActionPerformed(ActionEvent evt) {
		Question question = new Question();
		question.setID(jtxtid.getText());
		question.setQuestion(jtxttitle.getText());
		question.setForm(jtxtform.getText());
		question.setAnswer1(jtxtanswer1.getText());
		question.setAnswer2(jtxtanswer2.getText());
		question.setAnswer3(jtxtanswer3.getText());
		qci.add(question);

}
}
package com.yjz.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yjz.model.Model;
import com.yjz.model.Question;
import com.yjz.service.impl.control.ModelControllerImpl;
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
public class QuestionchangeView extends javax.swing.JFrame {
	private JLabel jlabid;
	private JButton jbtpass;
	private JTextField jtxtanswer3;
	private JLabel jlabanswer3;
	private JTextField jtxtanswer2;
	private JLabel jlabanswer2;
	private JTextField jtxtanswer1;
	private JLabel jlabanswer1;
	private JTextField jtxtquestion;
	private JLabel jlabquestion;
	private JTextField jtxtform;
	private JLabel jlabform;
	private JTextField jtxtid;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private QuestionControllerImpl qci;
	private ModelControllerImpl mci;
	private String temp;	
	public QuestionchangeView(QuestionControllerImpl qci,ModelControllerImpl mci,String temp) {
		this.qci = qci;
		this.mci = mci;
		this.temp = temp;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jlabid = new JLabel();
				getContentPane().add(jlabid);
				jlabid.setText("ID:");
				jlabid.setBounds(30, 27, 49, 20);
			}
			{
				jtxtid = new JTextField();
				getContentPane().add(jtxtid);
				jtxtid.setBounds(79, 20, 40, 27);
			}
			{
				jlabform = new JLabel();
				getContentPane().add(jlabform);
				jlabform.setText("\u7c7b\u578b\uff1a");
				jlabform.setBounds(158, 23, 56, 20);
			}
			{
				jtxtform = new JTextField();
				getContentPane().add(jtxtform);
				jtxtform.setBounds(237, 20, 49, 27);
			}
			{
				jlabquestion = new JLabel();
				getContentPane().add(jlabquestion);
				jlabquestion.setText("\u9898\u76ee\uff1a");
				jlabquestion.setBounds(30, 76, 60, 20);
			}
			{
				jtxtquestion = new JTextField();
				getContentPane().add(jtxtquestion);
				jtxtquestion.setBounds(89, 69, 241, 27);
			}
			{
				jlabanswer1 = new JLabel();
				getContentPane().add(jlabanswer1);
				jlabanswer1.setText("\u7b54\u6848\u4e00");
				jlabanswer1.setBounds(30, 114, 45, 20);
			}
			{
				jtxtanswer1 = new JTextField();
				getContentPane().add(jtxtanswer1);
				jtxtanswer1.setBounds(87, 111, 243, 27);
			}
			{
				jlabanswer2 = new JLabel();
				getContentPane().add(jlabanswer2);
				jlabanswer2.setText("\u7b54\u6848\u4e8c");
				jlabanswer2.setBounds(30, 152, 45, 20);
			}
			{
				jtxtanswer2 = new JTextField();
				getContentPane().add(jtxtanswer2);
				jtxtanswer2.setBounds(87, 149, 243, 27);
			}
			{
				jlabanswer3 = new JLabel();
				getContentPane().add(jlabanswer3);
				jlabanswer3.setText("\u7b54\u6848\u4e09");
				jlabanswer3.setBounds(30, 189, 45, 20);
			}
			{
				jtxtanswer3 = new JTextField();
				getContentPane().add(jtxtanswer3);
				jtxtanswer3.setBounds(87, 197, 243, 27);
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u786e\u5b9a");
				jbtpass.setBounds(57, 245, 101, 27);
				jbtpass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtpassActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 330);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jbtpassActionPerformed(ActionEvent evt) {
		Boolean flag1 = false;
		Boolean flag2 = false;
		Question question = new Question();
		question.setID(jtxtid.getText());
		question.setQuestion(jtxtquestion.getText());
		question.setForm(jtxtform.getText());
		question.setAnswer1(jtxtanswer1.getText());
		question.setAnswer2(jtxtanswer2.getText());
		question.setAnswer3(jtxtanswer3.getText());
		for ( Question que : qci.query()) {
			if(temp.equals(que.getID())){
				qci.delete(que);
				qci.add(question);
				flag1 = true;
			}
		}
		for (Model mod : mci.query()) {
			for (int i = 0; i < mod.getQinm().size(); i++) {
				if(mod.getQinm().get(i).getID().equals(temp)){
					mci.delete(mod, mod.getQinm().get(i));
					mci.add(mod, question);
					flag2 = true;
				}
			}
		}
		if(flag1&&flag2){
			JOptionPane.showMessageDialog(null, "修改成功");
		}else{
			JOptionPane.showMessageDialog(null, "修改失败");

		}
		
	}

}

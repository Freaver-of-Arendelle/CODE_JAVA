package com.yc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yc.model.Question;
import com.yc.service.control.QuestionServiceImpl;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AddQuestion extends javax.swing.JFrame {
	private JLabel jlabID;
	private JLabel jlabQuestion;
	private JTextField jtxtOC;
	private JLabel jlabOC;
	private JTextField jtxtOB;
	private JLabel jlabOB;
	private JTextField jtxtOA;
	private JLabel jlabOA;
	private JButton jbtReturn;
	private JLabel jlabType;
	private JTextField jtxtType;
	private JButton jbtAdd;
	private JTextField jtxtQuestion;
	private JTextField jtxtID;
	private QuestionServiceImpl qsi = new QuestionServiceImpl();

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public AddQuestion() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u95ee\u9898\u6dfb\u52a0");
			{
				jlabID = new JLabel();
				getContentPane().add(jlabID);
				jlabID.setText("ID");
				jlabID.setBounds(55, 59, 51, 20);
			}
			{
				jlabQuestion = new JLabel();
				getContentPane().add(jlabQuestion);
				jlabQuestion.setText("\u95ee\u9898");
				jlabQuestion.setBounds(49, 103, 30, 20);
			}
			{
				jtxtID = new JTextField();
				getContentPane().add(jtxtID);
				jtxtID.setBounds(118, 56, 61, 27);
			}
			{
				jtxtQuestion = new JTextField();
				getContentPane().add(jtxtQuestion);
				jtxtQuestion.setBounds(118, 103, 142, 30);
			}
			{
				jbtAdd = new JButton();
				getContentPane().add(jbtAdd);
				jbtAdd.setText("\u6dfb\u52a0");
				jbtAdd.setBounds(30, 329, 76, 27);
				jbtAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddActionPerformed(evt);
					}
				});
			}
			{
				jbtReturn = new JButton();
				getContentPane().add(jbtReturn);
				jbtReturn.setText("\u8fd4\u56de");
				jbtReturn.setBounds(226, 329, 70, 27);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			{
				jlabOA = new JLabel();
				getContentPane().add(jlabOA);
				jlabOA.setText("A");
				jlabOA.setBounds(61, 153, 11, 20);
			}
			{
				jtxtOA = new JTextField();
				getContentPane().add(jtxtOA);
				jtxtOA.setBounds(118, 150, 108, 27);
			}
			{
				jlabOB = new JLabel();
				getContentPane().add(jlabOB);
				jlabOB.setText("B");
				jlabOB.setBounds(61, 192, 10, 20);
			}
			{
				jtxtOB = new JTextField();
				getContentPane().add(jtxtOB);
				jtxtOB.setBounds(118, 189, 108, 27);
			}
			{
				jlabOC = new JLabel();
				getContentPane().add(jlabOC);
				jlabOC.setText("C");
				jlabOC.setBounds(61, 233, 10, 20);
			}
			{
				jtxtOC = new JTextField();
				getContentPane().add(jtxtOC);
				jtxtOC.setBounds(118, 230, 108, 27);
			}
			{
				jlabType = new JLabel();
				getContentPane().add(jlabType);
				jlabType.setText("\u7c7b\u578b");
				jlabType.setBounds(49, 265, 30, 20);
			}
			{
				jtxtType = new JTextField();
				getContentPane().add(jtxtType);
				jtxtType.setBounds(118, 269, 108, 27);
			}
			pack();
			this.setSize(343, 441);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jbtAddActionPerformed(ActionEvent evt) {
		Question q = new Question();
		q.setId(Integer.parseInt(this.jtxtID.getText()));
		q.setQuestion(this.jtxtQuestion.getText());
		q.setOptionA(this.jtxtOA.getText());
		q.setOptionB(this.jtxtOB.getText());
		q.setOptionC(this.jtxtOC.getText());
		q.setType(this.jtxtType.getText());
		if (qsi.register(q)) {
			JOptionPane.showMessageDialog(null, "添加成功！");
		} else {
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
	}

	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

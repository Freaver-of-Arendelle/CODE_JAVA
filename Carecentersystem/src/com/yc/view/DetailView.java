package com.yc.view;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yc.model.Question;
import javax.swing.JLabel;

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
public class DetailView extends javax.swing.JFrame {

	/**
	 * Auto-generated main method to display this JFrame
	 */
	private Question question;
	private JLabel jlabEA;
	private JLabel jlabOC;
	private JLabel jlabOB;
	private JLabel jlabOA;
	private JLabel jlabEC;
	private JLabel jlabEB;

	public DetailView(Question q) {
		super();
		this.question = q;
		initGUI();
	}

	public DetailView() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u95ee\u9898\u8be6\u60c5");
			{
				jlabEA = new JLabel();
				getContentPane().add(jlabEA);
				jlabEA.setText("\u9009\u9879A");
				jlabEA.setBounds(60, 53, 41, 20);
			}
			{
				jlabEB = new JLabel();
				getContentPane().add(jlabEB);
				jlabEB.setText("\u9009\u9879B");
				jlabEB.setBounds(60, 133, 39, 20);
			}
			{
				jlabEC = new JLabel();
				getContentPane().add(jlabEC);
				jlabEC.setText("\u9009\u9879C");
				jlabEC.setBounds(60, 217, 40, 20);
			}
			{
				jlabOA = new JLabel();
				getContentPane().add(jlabOA);
				jlabOA.setText(question.getOptionA());
				jlabOA.setBounds(139, 42, 140, 35);
			}
			{
				jlabOB = new JLabel();
				getContentPane().add(jlabOB);
				jlabOB.setText(question.getOptionB());
				jlabOB.setBounds(139, 123, 135, 35);
			}
			{
				jlabOC = new JLabel();
				getContentPane().add(jlabOC);
				jlabOC.setText(question.getOptionC());
				jlabOC.setBounds(151, 198, 145, 39);
			}
			pack();
			this.setSize(437, 398);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}

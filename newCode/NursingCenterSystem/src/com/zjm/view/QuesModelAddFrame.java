package com.zjm.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class QuesModelAddFrame extends javax.swing.JFrame {
	private JLabel lblTitle;
	private JButton btnBack;
	private JButton btnSave;
	private JTextField txtType;
	private JLabel jLabel1;
	private JTextField txtTitle;
	private Integer count;
	/**
	* Auto-generated main method to display this JFrame
	*/
	private QuestionModelControllerImpl qmci;	
	private QuestionControllerImpl qci;	
	public QuesModelAddFrame() {
		super();
		this.qmci = QuestionModelControllerImpl.getinstance();
		this.qci = QuestionControllerImpl.getinstance();
		this.count = 0;
		for (QuestionModel qm : qmci.query()) {
			if(qm.getId()>count){
				count = qm.getId();
			}
		}
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				lblTitle = new JLabel();
				getContentPane().add(lblTitle);
				lblTitle.setText("\u9898\u76ee");
				lblTitle.setBounds(59, 59, 38, 20);
			}
			{
				txtTitle = new JTextField();
				getContentPane().add(txtTitle);
				txtTitle.setBounds(120, 56, 170, 27);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u7c7b\u578b");
				jLabel1.setBounds(59, 108, 30, 20);
			}
			{
				txtType = new JTextField();
				getContentPane().add(txtType);
				txtType.setBounds(120, 105, 170, 27);
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(97, 175, 78, 27);
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
				btnBack.setBounds(212, 175, 78, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void btnSaveActionPerformed(ActionEvent evt) {
		QuestionModel qm = new QuestionModel(count+1,txtTitle.getText(),txtType.getText());
		qmci.add(qm);
		qmci.save();
		QuesModelListFrame qmlf = new QuesModelListFrame();
		qmlf.setLocationRelativeTo(null);
		qmlf.setVisible(true);
		this.dispose();
	}
	
	private void btnBackActionPerformed(ActionEvent evt) {
		QuesModelListFrame qmlf = new QuesModelListFrame();
		qmlf.setLocationRelativeTo(null);
		qmlf.setVisible(true);
		this.dispose();
	}

}

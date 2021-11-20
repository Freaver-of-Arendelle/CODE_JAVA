package com.zjm.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zjm.model.Worker;
import com.zjm.service.impl.controller.WorkerControllerImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
public class WorkerRegFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField txtAccount;
	private JLabel jLabel2;
	private JPasswordField pwdPassword;
	private JButton btnBack;
	private JButton btnReg;

	/**
	 * Auto-generated main method to display this JFrame
	 */


	private WorkerControllerImpl wci;

	public WorkerRegFrame() {
		super();
		this.wci = WorkerControllerImpl.getinstance();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7\uff1a");
				jLabel1.setBounds(65, 63, 45, 20);
			}
			{
				txtAccount = new JTextField();
				getContentPane().add(txtAccount);
				txtAccount.setBounds(122, 60, 194, 27);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801\uff1a");
				jLabel2.setBounds(65, 107, 45, 20);
			}
			{
				pwdPassword = new JPasswordField();
				getContentPane().add(pwdPassword);
				pwdPassword.setBounds(122, 107, 194, 27);
			}
			{
				btnReg = new JButton();
				getContentPane().add(btnReg);
				btnReg.setText("\u6ce8\u518c");
				btnReg.setBounds(77, 162, 63, 27);
				btnReg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnRegActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(227, 162, 63, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(405, 287);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void btnRegActionPerformed(ActionEvent evt) {
		Worker wkr = new Worker(this.txtAccount.getText(), new String(
				this.pwdPassword.getPassword()));
		if (wci.register(wkr)) {
			JOptionPane.showMessageDialog(null, "×¢²á³É¹¦");
		} else {
			JOptionPane.showMessageDialog(null, "×¢²áÊ§°Ü");
		}

	}

	private void thisWindowClosed(WindowEvent evt) {
		ManagerFrame mf = new ManagerFrame();
		mf.setLocationRelativeTo(null);
		mf.setVisible(true);
	}

	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

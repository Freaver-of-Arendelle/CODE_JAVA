package com.zjm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zjm.dao.impl.model.ManagerDAOImpl;
import com.zjm.model.Manager;
import com.zjm.model.Worker;
import com.zjm.service.impl.controller.ManagerControllerImpl;
import com.zjm.service.impl.controller.WorkerControllerImpl;

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
public class UserLoginFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField txtAccount;
	private JPasswordField pwdPassword;
	private JRadioButton rdoWorker;
	private JRadioButton rdoAdmin;
	private ButtonGroup buttonGroup1;
	private JButton btnExit;
	private JButton btnLogin;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UserLoginFrame inst = new UserLoginFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public UserLoginFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7\uff1a");
				jLabel1.setBounds(64, 57, 45, 20);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801\uff1a");
				jLabel2.setBounds(64, 99, 45, 20);
			}
			{
				txtAccount = new JTextField();
				getContentPane().add(txtAccount);
				txtAccount.setBounds(121, 54, 200, 27);
			}
			{
				pwdPassword = new JPasswordField();
				getContentPane().add(pwdPassword);
				pwdPassword.setBounds(121, 96, 200, 27);
			}
			{
				btnLogin = new JButton();
				getContentPane().add(btnLogin);
				btnLogin.setText("\u786e\u5b9a");
				btnLogin.setBounds(76, 191, 87, 27);
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnLoginActionPerformed(evt);
					}
				});
			}
			{
				btnExit = new JButton();
				getContentPane().add(btnExit);
				btnExit.setText("\u8fd4\u56de");
				btnExit.setBounds(203, 191, 87, 27);
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnExitActionPerformed(evt);
					}
				});
			}
			{
				rdoAdmin = new JRadioButton();
				getContentPane().add(rdoAdmin);
				rdoAdmin.setText("\u7cfb\u7edf\u7ba1\u7406\u5458");
				rdoAdmin.setBounds(70, 148, 93, 24);
				rdoAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rdoAdminActionPerformed(evt);
					}
				});
			}
			{
				rdoWorker = new JRadioButton();
				getContentPane().add(rdoWorker);
				rdoWorker.setText("\u5de5\u4f5c\u4eba\u5458");
				rdoWorker.setBounds(209, 148, 78, 24);
				rdoWorker.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						rdoWorkerActionPerformed(evt);
					}
				});
			}
			{
				getButtonGroup1().add(rdoAdmin);
				getButtonGroup1().add(rdoWorker);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	WorkerControllerImpl wci = WorkerControllerImpl.getinstance();
	ManagerControllerImpl mci = ManagerControllerImpl.getinstance();

	private void btnLoginActionPerformed(ActionEvent evt) {
		String account = this.txtAccount.getText();
		String password = new String(this.pwdPassword.getPassword());

		if (role == 1) {
			Manager mg = new Manager();
			mg.setAccount(account);
			mg.setPassword(password);
			if (mci.login(mg)) {
				ManagerFrame mf = new ManagerFrame();
				mf.setLocationRelativeTo(null);
				mf.setVisible(true);				
			} else {
				JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü");
			}

		} else if (role == 2) {
			Worker wk = new Worker();
			wk.setAccount(account);
			wk.setPassword(password);
			if (wci.login(wk)) {
				Vector<Worker> temp= wci.query();
				for (Worker worker : temp) {
					if (worker.getAccount().equals(wk.getAccount())) {
						WorkerFrame wf = new WorkerFrame(worker);
						wf.setLocationRelativeTo(null);
						wf.setVisible(true);
						break;
					}
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü");
			}

		} else {
			JOptionPane.showMessageDialog(null, "ÇëÑ¡Ôñ½ÇÉ«È¨ÏÞ£¡");
		}
	}

	Byte role = 0;

	private void rdoAdminActionPerformed(ActionEvent evt) {
		role = 1;
	}

	private void rdoWorkerActionPerformed(ActionEvent evt) {
		role = 2;
	}
	
	private void btnExitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

}

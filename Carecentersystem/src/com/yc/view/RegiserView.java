package com.yc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.yc.dao.impl.WorkerDAOImpl;
import com.yc.model.Worker;
import com.yc.service.control.WorkerServiceImpl;

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
public class RegiserView extends javax.swing.JFrame {
	private JLabel jlAccount;
	private JLabel jlPassword;
	private JTextField jtxtAccount;
	private JPasswordField jpwdPWD;
	private JPasswordField jpwdPWD2;
	private JLabel jlPWD2;
	private JButton jbtBack;
	private JButton jbtResgister;
	private WorkerServiceImpl wsi;
	private WorkerDAOImpl wdi;
	private Vector<Worker> workers;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public RegiserView() {
		super();
		wsi = new WorkerServiceImpl();
		wdi = new WorkerDAOImpl();
		workers = wdi.query();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5de5\u4f5c\u4eba\u5458\u6ce8\u518c");
			{
				jlAccount = new JLabel();
				getContentPane().add(jlAccount);
				jlAccount.setText("\u8d26\u53f7");
				jlAccount.setBounds(45, 45, 40, 20);
			}
			{
				jlPassword = new JLabel();
				getContentPane().add(jlPassword);
				jlPassword.setText("\u5bc6\u7801");
				jlPassword.setBounds(45, 101, 40, 20);
			}
			{
				jtxtAccount = new JTextField();
				getContentPane().add(jtxtAccount);
				jtxtAccount.setBounds(134, 42, 165, 27);
			}
			{
				jpwdPWD = new JPasswordField();
				getContentPane().add(jpwdPWD);
				jpwdPWD.setBounds(134, 98, 165, 27);
			}
			{
				jbtResgister = new JButton();
				getContentPane().add(jbtResgister);
				jbtResgister.setText("\u6ce8\u518c");
				jbtResgister.setBounds(45, 213, 80, 27);
				jbtResgister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtResgisterActionPerformed(evt);
					}
				});
			}
			{
				jbtBack = new JButton();
				getContentPane().add(jbtBack);
				jbtBack.setText("\u8fd4\u56de");
				jbtBack.setBounds(234, 218, 79, 27);
				jbtBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtBackActionPerformed(evt);
					}
				});
			}
			{
				jlPWD2 = new JLabel();
				getContentPane().add(jlPWD2);
				jlPWD2.setText("\u518d\u6b21\u8f93\u5165\u5bc6\u7801");
				jlPWD2.setBounds(18, 149, 90, 20);
			}
			{
				jpwdPWD2 = new JPasswordField();
				getContentPane().add(jpwdPWD2);
				jpwdPWD2.setBounds(134, 149, 165, 27);
			}
			pack();
			this.setSize(400, 340);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public Boolean isUsed(Vector<Worker> worker, String account) {
		Boolean f = true;
		for (int i = 0; i < worker.size(); i++) {
			Worker w = worker.get(i);
			if (w.getAccount().equals(account)) {

				f = false;
			}
		}
		return f;
	}

	private void jbtResgisterActionPerformed(ActionEvent evt) {
		String account = this.jtxtAccount.getText();
		Boolean f = this.isUsed(wdi.query(), account);
		//System.out.println(f);
		if (f) {
			String pwd1 = new String(this.jpwdPWD.getPassword());
			String pwd2 = new String(this.jpwdPWD2.getPassword());
			if (!pwd1.equals(pwd2)) {
				JOptionPane.showMessageDialog(null, "两次密码不一致！");
			} else {
				Worker worker = new Worker();
				worker.setAccount(account);
				worker.setPassword(pwd1);
				if (wsi.register(worker)) {
					JOptionPane.showMessageDialog(null, "注册成功！");
					Vector<Worker> workers=wdi.query();
					System.out.println("看看账号 是不是添加了");
					for (Worker worker2 : workers) {
						System.out.println(worker2.getAccount());
					}
				} else {
					JOptionPane.showMessageDialog(null, "注册失败！");
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "账号重复请换一个！");
		}
	}

	private void jbtBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

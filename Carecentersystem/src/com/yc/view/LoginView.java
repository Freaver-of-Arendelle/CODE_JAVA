package com.yc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

import com.yc.dao.impl.ManagerDAOImpl;
import com.yc.dao.impl.WorkerDAOImpl;
import com.yc.model.Manager;
import com.yc.model.Worker;
import com.yc.service.control.ManagerServiceImpl;
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
public class LoginView extends javax.swing.JFrame {
	private JLabel jlpwd;
	private JTextField jtxtAccount;
	private JPasswordField jpwd;
	private ButtonGroup bgMandW;
	private JButton jbtLogin;
	private JButton jbtback;
	private JRadioButton jrbWorker;
	private JRadioButton jrbManger;
	private JLabel jlAccount;
	private WorkerDAOImpl wdi = new WorkerDAOImpl();
	private List<Worker> workers = wdi.query();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginView inst = new LoginView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public LoginView() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u767b\u5f55\u754c\u9762");
			{
				jlpwd = new JLabel();
				getContentPane().add(jlpwd);
				jlpwd.setText("\u5bc6\u7801");
				jlpwd.setBounds(81, 109, 49, 20);
			}
			{
				jtxtAccount = new JTextField();
				getContentPane().add(jtxtAccount);
				jtxtAccount.setBounds(154, 44, 126, 27);
			}
			{
				jpwd = new JPasswordField();
				getContentPane().add(jpwd);
				jpwd.setBounds(154, 106, 126, 27);
			}
			{
				jlAccount = new JLabel();
				getContentPane().add(jlAccount);
				jlAccount.setText("\u8d26\u53f7");
				jlAccount.setBounds(81, 51, 36, 20);
			}
			{
				jrbManger = new JRadioButton();
				getContentPane().add(jrbManger);
				jrbManger.setText("\u7ba1\u7406\u4eba\u5458");
				jrbManger.setBounds(76, 158, 78, 24);
				jrbManger.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jrbMangerActionPerformed(evt);
					}
				});
			}
			{
				jrbWorker = new JRadioButton();
				getContentPane().add(jrbWorker);
				getContentPane().add(getJbtLogin());
				getContentPane().add(getJbtback());
				jrbWorker.setText("\u5de5\u4f5c\u4eba\u5458");
				jrbWorker.setBounds(231, 158, 78, 24);
				jrbWorker.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jrbWorkerActionPerformed(evt);
					}
				});
			}
			{
				getBgMandW().add(jrbManger);
				getBgMandW().add(jrbWorker);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ButtonGroup getBgMandW() {
		if (bgMandW == null) {
			bgMandW = new ButtonGroup();
		}
		return bgMandW;
	}

	private JButton getJbtLogin() {
		if (jbtLogin == null) {
			jbtLogin = new JButton();
			jbtLogin.setText("\u767b\u5f55");
			jbtLogin.setBounds(93, 196, 61, 27);
			jbtLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jbtLoginActionPerformed(evt);
				}
			});
		}
		return jbtLogin;
	}

	private JButton getJbtback() {
		if (jbtback == null) {
			jbtback = new JButton();
			jbtback.setText("\u8fd4\u56de");
			jbtback.setBounds(204, 196, 66, 27);
			jbtback.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jbtbackActionPerformed(evt);
				}
			});
		}
		return jbtback;
	}

	private void jbtLoginActionPerformed(ActionEvent evt) {
		ManagerServiceImpl msi = new ManagerServiceImpl();
		WorkerServiceImpl wsi = new WorkerServiceImpl();
		String account = jtxtAccount.getText();
		String pwd = new String(this.jpwd.getPassword());
		if (role == -1) {
			JOptionPane.showMessageDialog(null, "请选择你的身份");
		} else if (role == 0) {
			Manager manager = new Manager(account, pwd);
			if (msi.login(manager).equals("登陆成功")) {
				ManagerView mv = new ManagerView();
				mv.setVisible(true);
				mv.setLocationRelativeTo(null);
			} else {
				JOptionPane.showMessageDialog(null, "账号或密码错误");
			}
		} else if (role == 1) {
			Worker worker = new Worker(account, pwd);
			if (wsi.login(worker).equals("登陆成功")) {
				WorkerView wv = new WorkerView(this.SearchAccount(account),wdi);
				wv.setVisible(true);
				wv.setLocationRelativeTo(null);
			} else {
				JOptionPane.showMessageDialog(null, "账号或密码错误");
			}

		}

	}

	public Worker SearchAccount(String account) {
		Worker worker = new Worker();	
		Vector<Worker> nworkers =wdi.query();
		System.out.println("登录之前文档里的账号");
		for (Worker ww : nworkers)  {
		
			System.out.println(ww.getAccount());
		}
		for (Worker w : nworkers) {
			if (w.getAccount().equals(account)) {
				worker = w;
			}
		}
		return worker;
	}

	Byte role = -1;

	private void jrbMangerActionPerformed(ActionEvent evt) {
		role = 0;
	}

	private void jrbWorkerActionPerformed(ActionEvent evt) {
		role = 1; 
	}

	private void jbtbackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

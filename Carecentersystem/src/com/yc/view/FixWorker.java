package com.yc.view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class FixWorker extends javax.swing.JFrame {
	private JLabel jlabUserName;
	private JTextField jtxtName;
	private JTextField jtxtBirth;
	private JLabel jlabStrnegth;
	private JButton jbtReturn;
	private JTextField jtxtPosition;
	private JButton jbtFix;
	private JTextField jtxtPhone;
	private JLabel jlabPhone;
	private JLabel jlabPosition;
	private JTextField jtxtStrngth;
	private JLabel jlabBirth;
	private JLabel jlabName;
	private JTextField jtxtUsename;
	private Worker worker;
	// private WorkerServiceImpl wsi = new WorkerServiceImpl();
	private WorkerDAOImpl wdi;

	public FixWorker(Worker worker, WorkerDAOImpl wdi) {
		super();
		this.worker = worker;
		this.wdi = wdi;
		initGUI();
	}
//	public FixWorker(Worker worker) {
//		super();
//		this.worker = worker;
//		initGUI();
//	}

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public FixWorker() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5de5\u4f5c\u4eba\u5458\u4fe1\u606f\u4fee\u6539");
			{
				jlabUserName = new JLabel();
				getContentPane().add(jlabUserName);
				jlabUserName.setText("\u7528\u6237\u540d");
				jlabUserName.setBounds(22, 40, 45, 20);
			}
			{
				jtxtUsename = new JTextField();
				getContentPane().add(jtxtUsename);
				jtxtUsename.setBounds(107, 37, 162, 27);
			}
			{
				jlabName = new JLabel();
				getContentPane().add(jlabName);
				jlabName.setText("\u59d3\u540d");
				jlabName.setBounds(34, 91, 30, 27);
			}
			{
				jtxtName = new JTextField();
				getContentPane().add(jtxtName);
				jtxtName.setBounds(107, 91, 162, 27);
			}
			{
				jlabBirth = new JLabel();
				getContentPane().add(jlabBirth);
				jlabBirth.setText("\u51fa\u751f\u65e5\u671f");
				jlabBirth.setBounds(22, 143, 60, 20);
			}
			{
				jtxtBirth = new JTextField();
				getContentPane().add(jtxtBirth);
				jtxtBirth.setBounds(107, 143, 162, 27);
			}
			{
				jlabStrnegth = new JLabel();
				getContentPane().add(jlabStrnegth);
				jlabStrnegth.setText("\u7279\u957f");
				jlabStrnegth.setBounds(34, 195, 30, 20);
			}
			{
				jtxtStrngth = new JTextField();
				getContentPane().add(jtxtStrngth);
				jtxtStrngth.setBounds(107, 192, 162, 27);
			}
			{
				jlabPosition = new JLabel();
				getContentPane().add(jlabPosition);
				jlabPosition.setText("\u804c\u79f0");
				jlabPosition.setBounds(34, 244, 30, 20);
			}
			{
				jtxtPosition = new JTextField();
				getContentPane().add(jtxtPosition);
				jtxtPosition.setBounds(107, 241, 162, 27);
			}
			{
				jlabPhone = new JLabel();
				getContentPane().add(jlabPhone);
				jlabPhone.setText("\u8054\u7cfb\u7535\u8bdd");
				jlabPhone.setBounds(22, 286, 60, 20);
			}
			{
				jtxtPhone = new JTextField();
				getContentPane().add(jtxtPhone);
				jtxtPhone.setBounds(107, 286, 162, 27);
			}
			{
				jbtFix = new JButton();
				getContentPane().add(jbtFix);
				jbtFix.setText("\u4fee\u6539");
				jbtFix.setBounds(57, 342, 66, 32);
				jbtFix.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtFixActionPerformed(evt);
					}
				});
			}
			{
				jbtReturn = new JButton();
				getContentPane().add(jbtReturn);
				jbtReturn.setText("\u8fd4\u56de");
				jbtReturn.setBounds(188, 342, 64, 32);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 480);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jbtFixActionPerformed(ActionEvent evt) {
//		worker.setAccount(worker.getAccount());
//		worker.setPassword(worker.getPassword());
		System.out.println("看看传进来的哪个账号");
		System.out.println(worker.getAccount());
		worker.setUsername(this.jtxtUsename.getText());
		worker.setName(this.jtxtName.getText());
		worker.setBirthday(this.jtxtBirth.getText());
		worker.setStrength(this.jtxtStrngth.getText());
		worker.setPosition(this.jtxtPosition.getText());
		worker.setPhone(this.jtxtPhone.getText());
		//wdi.register(worker);
		wdi.writeFile("c:\\abc\\users.txt");
	   Vector<Worker> workers =wdi.query();
	   System.out.println("看看名字");
		for (Worker w : workers) {
			System.out.println(w.getName());
		}
		JOptionPane.showMessageDialog(null, "修改成功！");

	}

	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

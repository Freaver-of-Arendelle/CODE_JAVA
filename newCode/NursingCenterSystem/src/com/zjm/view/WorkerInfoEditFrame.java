package com.zjm.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.SwingUtilities;

import com.zjm.model.Worker;
import com.zjm.service.impl.controller.WorkerControllerImpl;


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
public class WorkerInfoEditFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel lblPhone;
	private JLabel lblJobTitle;
	private JLabel lblSpeciality;
	private JLabel lblBirthday;
	private JLabel lblName;
	private JButton btnBack;
	private JButton btnSave;
	private JLabel lblAccount;
	private JTextField txtName;
	private JLabel jLabel2;
	private JTextField txtPhone;
	private JTextField txtJobtitle;
	private JTextField txtSpeciality;
	private JTextField txtBirthday;
	private JLabel jLabel7;
	private JLabel jLabel6;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public WorkerInfoEditFrame() {
		super();
		initGUI();
	}
	private Worker worker;
	private WorkerControllerImpl wci;
	public WorkerInfoEditFrame(Worker worker) {
		super();
		this.worker = worker;
		this.wci = WorkerControllerImpl.getinstance();
		initGUI();
		lblAccount.setText(worker.getAccount());
		lblName.setText(worker.getRealname());
		lblBirthday.setText(worker.getBirthday());
		lblPhone.setText(worker.getPhone());
		lblSpeciality.setText(worker.getSpecialty());
		lblJobTitle.setText(worker.getJobtitle());
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7\uff1a");
				jLabel1.setBounds(20, 20, 45, 20);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u59d3\u540d\uff1a");
				jLabel3.setBounds(20, 62, 45, 20);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u51fa\u751f\u65e5\u671f\uff1a");
				jLabel4.setBounds(12, 101, 75, 20);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u4e13\u957f\uff1a");
				jLabel5.setBounds(20, 140, 45, 20);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u804c\u79f0\uff1a");
				jLabel6.setBounds(20, 179, 45, 20);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u8054\u7cfb\u7535\u8bdd\uff1a");
				jLabel7.setBounds(12, 218, 75, 20);
			}
			{
				txtName = new JTextField();
				getContentPane().add(txtName);
				txtName.setBounds(240, 59, 93, 27);
			}
			{
				txtBirthday = new JTextField();
				getContentPane().add(txtBirthday);
				txtBirthday.setBounds(240, 98, 134, 27);
			}
			{
				txtSpeciality = new JTextField();
				getContentPane().add(txtSpeciality);
				txtSpeciality.setBounds(240, 137, 134, 27);
			}
			{
				txtJobtitle = new JTextField();
				getContentPane().add(txtJobtitle);
				txtJobtitle.setBounds(240, 176, 134, 27);
			}
			{
				txtPhone = new JTextField();
				getContentPane().add(txtPhone);
				txtPhone.setBounds(240, 215, 134, 27);
			}
			{
				lblAccount = new JLabel();
				getContentPane().add(lblAccount);
				lblAccount.setBounds(126, 20, 93, 27);
				lblAccount.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lblAccount.setEnabled(false);
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(86, 313, 66, 29);
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
				btnBack.setBounds(195, 313, 66, 29);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				lblName = new JLabel();
				getContentPane().add(lblName);
				lblName.setBounds(126, 59, 92, 27);
				lblName.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lblName.setEnabled(false);
			}
			{
				lblBirthday = new JLabel();
				getContentPane().add(lblBirthday);
				lblBirthday.setBounds(126, 98, 92, 27);
				lblBirthday.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lblBirthday.setEnabled(false);
			}
			{
				lblSpeciality = new JLabel();
				getContentPane().add(lblSpeciality);
				lblSpeciality.setBounds(126, 137, 92, 27);
				lblSpeciality.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lblSpeciality.setEnabled(false);
			}
			{
				lblJobTitle = new JLabel();
				getContentPane().add(lblJobTitle);
				lblJobTitle.setBounds(126, 176, 92, 27);
				lblJobTitle.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lblJobTitle.setEnabled(false);
			}
			{
				lblPhone = new JLabel();
				getContentPane().add(lblPhone);
				lblPhone.setBounds(126, 215, 92, 27);
				lblPhone.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				lblPhone.setEnabled(false);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u4fee\u6539\u540e");
				jLabel2.setBounds(240, 20, 83, 27);
			}
			pack();
			this.setSize(400, 413);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void btnSaveActionPerformed(ActionEvent evt) {
		worker.setRealname(txtName.getText().equals("")?worker.getRealname():txtName.getText());
		worker.setBirthday(txtBirthday.getText().equals("")?worker.getBirthday():txtBirthday.getText());
		worker.setSpecialty(txtSpeciality.getText().equals("")?worker.getSpecialty():txtSpeciality.getText());
		worker.setJobtitle(txtJobtitle.getText().equals("")?worker.getJobtitle():txtJobtitle.getText());
		worker.setPhone(txtPhone.getText().equals("")?worker.getPhone():txtPhone.getText());
//		if () {
		wci.save();
		JOptionPane.showMessageDialog(null, "±£´æ³É¹¦£¡");
//		}
		
	}
	
	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

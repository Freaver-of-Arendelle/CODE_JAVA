package com.zjm.view;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.zjm.model.Patient;
import com.zjm.model.Worker;
import com.zjm.service.impl.controller.PatientControllerImpl;
import com.zjm.service.impl.controller.WorkerControllerImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

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
public class PatientRegFrame extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField txtName;
	private JButton btnAdd;
	private ButtonGroup buttonGroup1;
	private JButton btnBack;
	private JTextField txtEmergentContactPhone;
	private JRadioButton jrdoMale;
	private JLabel jLabel5;
	private JTextField txtPhone;
	private JLabel jLabel7;
	private JTextField txtEmergencyContact;
	private JLabel jLabel6;
	private JTextField txtIdnum;
	private JLabel jLabel4;
	private JRadioButton jrdoFemale;
	private JLabel jLabel3;
	private JTextField txtBirthday;
	private JLabel jLabel2;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	
	private PatientControllerImpl pci;
	private Worker currWorker;
	public PatientRegFrame(Worker currWorker) {
		super();
		this.pci = PatientControllerImpl.getinstance();
		this.currWorker = currWorker;
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
				jLabel1.setText("\u59d3\u540d\uff1a");
				jLabel1.setBounds(84, 39, 46, 20);
			}
			{
				txtName = new JTextField();
				getContentPane().add(txtName);
				txtName.setBounds(152, 36, 173, 27);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u51fa\u751f\u65e5\u671f\uff1a");
				jLabel2.setBounds(56, 75, 78, 20);
			}
			{
				txtBirthday = new JTextField();
				getContentPane().add(txtBirthday);
				txtBirthday.setBounds(152, 68, 173, 27);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u6027\u522b\uff1a");
				jLabel3.setBounds(84, 112, 50, 20);
			}
			{
				jrdoMale = new JRadioButton();
				getContentPane().add(jrdoMale);
				jrdoMale.setText("\u7537");
				jrdoMale.setBounds(173, 105, 49, 24);
			}
			{
				jrdoFemale = new JRadioButton();
				getContentPane().add(jrdoFemale);
				jrdoFemale.setText("\u5973");
				jrdoFemale.setBounds(259, 105, 49, 24);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u8eab\u4efd\u8bc1\u53f7\uff1a");
				jLabel4.setBounds(56, 144, 78, 20);
			}
			{
				txtIdnum = new JTextField();
				getContentPane().add(txtIdnum);
				txtIdnum.setBounds(150, 137, 195, 27);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("\u8054\u7cfb\u7535\u8bdd\uff1a");
				jLabel5.setBounds(56, 181, 78, 20);
			}
			{
				txtPhone = new JTextField();
				getContentPane().add(txtPhone);
				txtPhone.setBounds(150, 174, 175, 27);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("\u7d27\u6025\u8054\u7cfb\u4eba\uff1a");
				jLabel6.setBounds(44, 219, 90, 20);
			}
			{
				txtEmergencyContact = new JTextField();
				getContentPane().add(txtEmergencyContact);
				txtEmergencyContact.setBounds(148, 215, 177, 27);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("\u7d27\u6025\u8054\u7cfb\u4eba\u7535\u8bdd\uff1a");
				jLabel7.setBounds(14, 258, 120, 20);
			}
			{
				txtEmergentContactPhone = new JTextField();
				getContentPane().add(txtEmergentContactPhone);
				txtEmergentContactPhone.setBounds(149, 251, 178, 27);
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u6dfb\u52a0");
				btnAdd.setBounds(63, 312, 71, 27);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(232, 312, 71, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				this.getButtonGroup1().add(jrdoMale);
				this.getButtonGroup1().add(jrdoFemale);
			}
			pack();
			this.setSize(400, 413);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		Patient patient = new Patient();
		patient.setName(txtName.getText());
		patient.setBirthday(txtBirthday.getText());
		patient.setIdnum(txtIdnum.getText());
		patient.setPhone(txtPhone.getText());
		patient.setEmergencyContact(txtEmergencyContact.getText());
		patient.setEmergencyContactPhone(txtEmergentContactPhone.getText());
		//获取按钮组选中内容 性别
		Enumeration<AbstractButton> radioBtns=this.getButtonGroup1().getElements();  
		while (radioBtns.hasMoreElements()) {  
		    AbstractButton btn = radioBtns.nextElement();  
		    if(btn.isSelected()){  
		        patient.setGender(btn.getText());
		        break;  
		    }  
		}  
		if (pci.add(patient)) {
			JOptionPane.showMessageDialog(null, "添加成功");
		}else {
			JOptionPane.showMessageDialog(null, "添加失败");
		}
		
		
	}
	
	private void thisWindowClosed(WindowEvent evt) {
		WorkerFrame wf = new WorkerFrame(currWorker);
		wf.setLocationRelativeTo(null);
		wf.setVisible(true);
	}
	
	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

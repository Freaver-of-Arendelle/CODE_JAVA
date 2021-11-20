package com.yjz.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import com.yjz.model.*;
import com.yjz.service.control.AdminController;
import com.yjz.service.control.MaxAdminController;
import com.yjz.service.control.PatientController;
import com.yjz.service.impl.control.AdminControllerImpl;
import com.yjz.service.impl.control.MaxAdminControllerImpl;
import com.yjz.service.impl.control.PatientControllerImpl;

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
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jbtclose;
	private ButtonGroup buttonGroup2;
	private JRadioButton jrbtadmin;
	private JRadioButton jrbtmaxAdmin;
	private JButton jbtpass;
	private JPasswordField jpwd;
	private JTextField jtxtuserName;

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
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7\uff1a");
				jLabel1.setBounds(32, 61, 45, 20);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801\uff1a");
				jLabel2.setBounds(32, 119, 45, 20);
			}
			{
				jtxtuserName = new JTextField();
				getContentPane().add(jtxtuserName);
				jtxtuserName.setBounds(107, 61, 186, 27);
			}
			{
				jpwd = new JPasswordField();
				getContentPane().add(jpwd);
				jpwd.setBounds(107, 116, 186, 27);
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u786e\u5b9a");
				jbtpass.setBounds(87, 208, 44, 27);
				jbtpass.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtpassActionPerformed(evt);
					}
				});
			}
			{
				jbtclose = new JButton();
				getContentPane().add(jbtclose);
				jbtclose.setText("\u8fd4\u56de");
				jbtclose.setBounds(191, 212, 44, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
					}
				});
			}
			{
				jrbtmaxAdmin = new JRadioButton();
				getContentPane().add(jrbtmaxAdmin);
				jrbtmaxAdmin.setText("\u7ba1\u7406\u5458");
				jrbtmaxAdmin.setBounds(95, 165, 63, 24);
				jrbtmaxAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jrbtmaxAdminActionPerformed(evt);
					}
				});
			}
			{
				jrbtadmin = new JRadioButton();
				getContentPane().add(jrbtadmin);
				jrbtadmin.setText("\u5de5\u4f5c\u4eba\u5458");
				jrbtadmin.setBounds(204, 165, 78, 24);
				jrbtadmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jrbtadminActionPerformed(evt);
					}
				});
			}
			{
				getButtonGroup2().add(jrbtadmin);
				getButtonGroup2().add(jrbtmaxAdmin);
			}
			pack();
			this.setSize(425, 325);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}


	private AdminControllerImpl admin = AdminControllerImpl.getinstance();
	private PatientControllerImpl patient = PatientControllerImpl.getinstance();
	private MaxAdminControllerImpl maxadmin = MaxAdminControllerImpl.getinstance(); 
	private void jbtpassActionPerformed(ActionEvent evt) {
		Admin temp = new Admin();
		Admin temp1 = new Admin();
		temp.setAccount(jtxtuserName.getText());
		temp.setPassword(new String(jpwd.getPassword()));
		MaxAdmin max = new MaxAdmin(jtxtuserName.getText(),new String(jpwd.getPassword()));
		Boolean flag1 = false;	
		//System.out.println(maxadmin.login(max));
		if (maxadmin.login(max)&&flag) {
				// 跳转至管理员界面
				flag1 = true;
				if(flag1){
					JOptionPane.showMessageDialog(null, "登录成功");
				}
				MaxAdminView mav = new MaxAdminView(admin);
				mav.setLocationRelativeTo(null);
				mav.setVisible(true);
				
			}
			 if(admin.login(temp)&&!flag){
			 //跳转至医患界面
				 for (Admin adm : admin.query()) {
						if(adm.getPassword().equals(temp.getPassword())&&adm.getAccount().equals(temp.getAccount())){
						flag1 = true;
						if(flag1){
							JOptionPane.showMessageDialog(null, "登录成功");
						}
						temp1 = adm;
						break;
						}
					}
				PatientView mav = new PatientView(patient,temp1);
				mav.setLocationRelativeTo(null);
				mav.setVisible(true);
			 }
		if(!flag1){
			JOptionPane.showMessageDialog(null, "登录失败");
		}
		
	}

	private void jbtcloseActionPerformed(ActionEvent evt) {
		System.exit(0);// 关闭
	}

	private ButtonGroup getButtonGroup2() {
		if (buttonGroup2 == null) {
			buttonGroup2 = new ButtonGroup();
		}
		return buttonGroup2;
	}

	public Boolean flag;

	private Boolean jrbtadminActionPerformed(ActionEvent evt) {
		return flag = false;
	}

	private Boolean jrbtmaxAdminActionPerformed(ActionEvent evt) {
		return flag = true;
	}

}

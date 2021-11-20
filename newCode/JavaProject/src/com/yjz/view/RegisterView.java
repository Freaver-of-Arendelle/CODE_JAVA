package com.yjz.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yjz.model.Admin;
import com.yjz.service.impl.control.AdminControllerImpl;
import com.yjz.impl.model.*;;

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
public class RegisterView extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jbtclose;
	private JButton jbtpass;
	private JPasswordField jpwd;
	private JTextField jtxtuserName;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private AdminControllerImpl ad;
	public RegisterView(AdminControllerImpl ad) {
		this.ad = ad;
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
				jLabel1.setBounds(39, 54, 45, 20);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801\uff1a");
				jLabel2.setBounds(39, 118, 45, 20);
			}
			{
				jtxtuserName = new JTextField();
				getContentPane().add(jtxtuserName);
				jtxtuserName.setBounds(102, 51, 176, 27);
			}
			{
				jpwd = new JPasswordField();
				getContentPane().add(jpwd);
				jpwd.setBounds(102, 111, 176, 27);
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u786e\u5b9a");
				jbtpass.setBounds(51, 179, 44, 27);
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
				jbtclose.setBounds(196, 179, 44, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
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
	private void jbtpassActionPerformed(ActionEvent evt) {
		Admin admin = new Admin();
		admin.setAccount(jtxtuserName.getText());
		admin.setPassword(new String(jpwd.getPassword()));
		if(ad.register(admin)){
			JOptionPane.showMessageDialog(null, "注册成功");
		}
	}
	
	private void jbtcloseActionPerformed(ActionEvent evt) {
		//返回登录界面
		LoginView lgv = new LoginView();
		lgv.setLocationRelativeTo(null);
		lgv.setVisible(true);
		
	}

}

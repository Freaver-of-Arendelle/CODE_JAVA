package com.yc.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yc.model.Patient;
import com.yc.service.control.PatientServiceImpl;


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
public class AddPatient extends javax.swing.JFrame {
	private JLabel jlabName;
	private JLabel jlabGender;
	private JTextField jtxtEmercy;
	private JTextField jtxtEmPhone;
	private JTextField jtxtPhone;
	private JLabel jlabIDNo;
	private JTextField jTextIDno;
	private JButton jbtReturn;
	private JButton jbtAddPat;
	private JTextField jTextGender;
	private JTextField jTextBirth;
	private JTextField jTextName;
	private JLabel jlabEmPhone;
	private JLabel jlabEmercy;
	private JLabel jlabPhone;
	private JLabel jlabBirth;
	private PatientServiceImpl psi = new PatientServiceImpl();
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				AddPatient inst = new AddPatient();
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
	}
	
	public AddPatient() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u75c5\u4eba\u6dfb\u52a0");
			{
				jlabName = new JLabel();
				getContentPane().add(jlabName);
				jlabName.setText("\u59d3\u540d");
				jlabName.setBounds(53, 45, 30, 20);
			}
			{
				jlabGender = new JLabel();
				getContentPane().add(jlabGender);
				jlabGender.setText("\u6027\u522b");
				jlabGender.setBounds(56, 118, 30, 20);
			}
			{
				jlabBirth = new JLabel();
				getContentPane().add(jlabBirth);
				jlabBirth.setText("\u51fa\u751f\u65e5\u671f");
				jlabBirth.setBounds(41, 81, 60, 20);
			}
			{
				jlabIDNo = new JLabel();
				getContentPane().add(jlabIDNo);
				jlabIDNo.setText("\u8eab\u4efd\u8bc1\u53f7\u7801");
				jlabIDNo.setBounds(29, 163, 75, 20);
			}
			{
				jlabPhone = new JLabel();
				getContentPane().add(jlabPhone);
				jlabPhone.setText("\u8054\u7cfb\u7535\u8bdd");
				jlabPhone.setBounds(40, 205, 60, 20);
			}
			{
				jlabEmercy = new JLabel();
				getContentPane().add(jlabEmercy);
				jlabEmercy.setText("\u7d27\u6025\u8054\u7cfb\u4eba");
				jlabEmercy.setBounds(34, 256, 75, 20);
			}
			{
				jlabEmPhone = new JLabel();
				getContentPane().add(jlabEmPhone);
				jlabEmPhone.setText("\u7d27\u6025\u8054\u7cfb\u4eba\u7535\u8bdd");
				jlabEmPhone.setBounds(17, 308, 105, 20);
			}
			{
				jTextName = new JTextField();
				getContentPane().add(jTextName);
				jTextName.setBounds(182, 42, 181, 27);
			}
			{
				jTextBirth = new JTextField();
				getContentPane().add(jTextBirth);
				jTextBirth.setBounds(182, 78, 181, 27);
			}
			{
				jTextGender = new JTextField();
				getContentPane().add(jTextGender);
				jTextGender.setBounds(182, 115, 181, 27);
			}
			{
				jTextIDno = new JTextField();
				getContentPane().add(jTextIDno);
				jTextIDno.setBounds(182, 160, 181, 27);
			}
			{
				jtxtPhone = new JTextField();
				getContentPane().add(jtxtPhone);
				jtxtPhone.setBounds(182, 202, 181, 27);
			}
			{
				jtxtEmercy = new JTextField();
				getContentPane().add(jtxtEmercy);
				jtxtEmercy.setBounds(182, 253, 181, 27);
			}
			{
				jtxtEmPhone = new JTextField();
				getContentPane().add(jtxtEmPhone);
				jtxtEmPhone.setBounds(182, 308, 181, 27);
			}
			{
				jbtAddPat = new JButton();
				getContentPane().add(jbtAddPat);
				jbtAddPat.setText("\u6dfb\u52a0");
				jbtAddPat.setBounds(68, 368, 66, 37);
				jbtAddPat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddPatActionPerformed(evt);
					}
				});
			}
			{
				jbtReturn = new JButton();
				getContentPane().add(jbtReturn);
				jbtReturn.setText("\u8fd4\u56de");
				jbtReturn.setBounds(203, 370, 72, 33);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(426, 477);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jbtAddPatActionPerformed(ActionEvent evt) {
		Patient p =new Patient();
		p.setName(this.jTextName.getText());
		p.setBirthday(this.jTextBirth.getText());
		p.setGender(this.jTextGender.getText());
		p.setIdno(this.jTextIDno.getText());
		p.setPhone(this.jtxtEmPhone.getText());
		p.setEmercyant(this.jtxtEmercy.getText());
		p.setEmercyphone(this.jtxtEmPhone.getText());
		if(psi.register(p)){
			JOptionPane.showMessageDialog(null, "×¢²á³É¹¦£¡");
		} else {
			JOptionPane.showMessageDialog(null, "×¢²áÊ§°Ü£¡");
		}
	}
			
	
	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

package com.yc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yc.model.Model;
import com.yc.service.control.ModelServiceImpl;

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
public class AddModel extends javax.swing.JFrame {
	private JLabel jlabQue;
	private JLabel jlabType;
	private JButton jbtReturn;
	private JButton jbtAdd;
	private JTextField jtxtType;
	private JTextField jtxtQue;
	private ModelServiceImpl msi = new ModelServiceImpl();

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public AddModel() {
		super();
		initGUI();
	}

	private void initGUI() {
		msi.query();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u95ee\u5377\u6dfb\u52a0");
			{
				jlabQue = new JLabel();
				getContentPane().add(jlabQue);
				jlabQue.setText("\u9898\u76ee");
				jlabQue.setBounds(43, 39, 65, 27);
			}
			{
				jtxtQue = new JTextField();
				getContentPane().add(jtxtQue);
				jtxtQue.setBounds(107, 39, 79, 27);
			}
			{
				jlabType = new JLabel();
				getContentPane().add(jlabType);
				jlabType.setText("\u7c7b\u578b");
				jlabType.setBounds(48, 103, 38, 26);
			}
			{
				jtxtType = new JTextField();
				getContentPane().add(jtxtType);
				jtxtType.setBounds(108, 103, 38, 27);
			}
			{
				jbtAdd = new JButton();
				getContentPane().add(jbtAdd);
				jbtAdd.setText("\u589e\u52a0");
				jbtAdd.setBounds(36, 154, 72, 40);
				jbtAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddActionPerformed(evt);
					}
				});
			}
			{
				jbtReturn = new JButton();
				getContentPane().add(jbtReturn);
				jbtReturn.setText("\u8fd4\u56de");
				jbtReturn.setBounds(158, 154, 75, 40);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(319, 273);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	private void jbtAddActionPerformed(ActionEvent evt) {
		Model m = new Model();
		m.setName(this.jtxtQue.getText());
		m.setType(this.jtxtType.getText());
		if (msi.register(m)) {
			JOptionPane.showMessageDialog(null, "×¢²á³É¹¦£¡");
		} else {
			JOptionPane.showMessageDialog(null, "×¢²áÊ§°Ü£¡");
		}
	}

}

package com.yjz.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yjz.model.Access;
import com.yjz.model.Admin;
import com.yjz.model.Model;
import com.yjz.model.Patient;
import com.yjz.service.impl.control.AccessControllerImpl;
import com.yjz.service.impl.control.ModelControllerImpl;


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
public class EvaluateView extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jbtclose;
	private JButton jbtstart;
	private JComboBox jComboBox1;
	private JTable jtbevaluate;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private AccessControllerImpl aci = AccessControllerImpl.getinstance();
	private Admin admin;
	private ModelControllerImpl mci;
	private Patient pat;
	public EvaluateView(ModelControllerImpl mci,Admin admin,Patient pat) {
		this.mci = mci;
		this.admin = admin;
		this.pat = pat;
		this.model.setID("-1");
		initGUI();
	}
	Vector<Vector<String>> datas = new Vector<Vector<String>> ();
	private void initGUI() {
		for (Access ac : aci.query()) {
			//System.out.println("卢本伟");
			Vector<String> data = new Vector<String>();
			data.add(ac.getPatient());
			data.add(ac.getGender());
			data.add(ac.getModel());
			data.add(ac.getModelform());
			data.add(ac.getTime()+"");
			data.add(ac.getAccessman());
			data.add(ac.getAdvice());
			datas.add(data);
		}
		Vector<String> datas1 = new Vector<String>();
		for(Model mod : mci.query()){
			String temp = mod.getTitle();
			datas1.add(temp);
		}
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 76, 387, 173);
				{
					TableModel jtbevaluateModel = 
						new DefaultTableModel(
								datas,
								aci.getColnames());
					jtbevaluate = new JTable();
					jScrollPane1.setViewportView(getJtbevaluate());
					jtbevaluate.setModel(jtbevaluateModel);
				}
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
						datas1	);
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(281, 30, 112, 27);
				jComboBox1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jComboBox1ActionPerformed(evt);
					}
				});
			}
			{
				jbtstart = new JButton();
				getContentPane().add(jbtstart);
				jbtstart.setText("\u5f00\u59cb\u8bc4\u4f30");
				jbtstart.setBounds(12, 30, 95, 27);
				jbtstart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtstartActionPerformed(evt);
					}
				});
			}
			{
				jbtclose = new JButton();
				getContentPane().add(jbtclose);
				jbtclose.setText("\u5173\u95ed");
				jbtclose.setBounds(293, 272, 100, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(429, 376);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public JTable getJtbevaluate() {
		return jtbevaluate;
	}
	
	private void jbtstartActionPerformed(ActionEvent evt) {
		if(model.getID().equals("-1")){
			JOptionPane.showMessageDialog(null, "请先选择模板");
		}else{
			
			FinalAccessView fav = new FinalAccessView(model,admin,pat,aci);
			fav.setLocationRelativeTo(null);
			fav.setVisible(true);
		}
	}
	private Model model = new Model();
	private void jComboBox1ActionPerformed(ActionEvent evt) {
		String temp = jComboBox1.getSelectedItem().toString();
		//System.out.println(temp);
		for (Model mod : mci.query()) {
		if(mod.getTitle().equals(temp)){
			this.model = mod;
			break;
		}
		}
	}
	
	private void jbtcloseActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

}

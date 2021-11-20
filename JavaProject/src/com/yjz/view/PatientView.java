package com.yjz.view;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yjz.impl.model.PatientDAOImpl;
import com.yjz.model.Admin;
import com.yjz.model.Patient;
import com.yjz.service.control.PatientController;
import com.yjz.service.impl.control.ModelControllerImpl;
import com.yjz.service.impl.control.PatientControllerImpl;
import com.yjz.dao.model.ModelDAO;
import com.yjz.dao.tool.*;

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
public class PatientView extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jbtclose;
	private JButton jbtsearch;
	private JTextField jtxtsearch;
	private JButton jbtchange;
	private JButton jbtadd;
	private JButton jbtmodelList;
	private JButton jbtdelete;
	private JButton jbtpass;
	private JTable jtablepatient;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private PatientControllerImpl pc;
	private Admin admin;
	public PatientView(PatientControllerImpl pc, Admin admin) {
		this.pc=pc;
		this.admin = admin;
		//System.out.println(admin.getRealName());
		initGUI();
	}

	Vector<Vector> datas = new Vector<Vector>();
	
	private void initGUI() {
		Vector<Patient> patient= new Vector<Patient>();
		for (Patient pat: pc.query()) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(pat.getName());
			data.add(pat.getBirth());
			data.add(pat.getGender());
			data.add(pat.getID());
			data.add(pat.getPhone());
			data.add(pat.getEmergency());
			data.add(pat.getEmergencyPhone());
			data.add("");
			datas.add(data);
		}
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(24, 108, 458, 180);
				{
					TableModel jtablepatientModel = 
						new DefaultTableModel(
								datas,
								pc.getColNames());
					jtablepatient = new JTable();
					jScrollPane1.setViewportView(jtablepatient);
					jtablepatient.setModel(jtablepatientModel);
					TableColumn tc = jtablepatient.getColumnModel().getColumn(0);  
					tc.setCellEditor(jtablepatient.getDefaultEditor(Boolean.class));  
					tc.setCellRenderer(jtablepatient.getDefaultRenderer(Boolean.class));
					tc = jtablepatient.getColumnModel().getColumn(8);
					tc.setCellEditor(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
					tc.setCellRenderer(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
				}
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u4fdd\u5b58");
				jbtpass.setBounds(60, 300, 104, 27);
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
				jbtclose.setBounds(377, 300, 96, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
					}
				});
			}
			{
				jbtdelete = new JButton();
				getContentPane().add(jbtdelete);
				jbtdelete.setText("\u5220\u9664");
				jbtdelete.setBounds(31, 70, 75, 27);
				jbtdelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtdeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtmodelList = new JButton();
				getContentPane().add(jbtmodelList);
				jbtmodelList.setText("\u6a21\u677f\u5217\u8868");
				jbtmodelList.setBounds(296, 70, 74, 27);
				jbtmodelList.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtmodelListActionPerformed(evt);
					}
				});
			}
			{
				jbtadd = new JButton();
				getContentPane().add(jbtadd);
				jbtadd.setText("\u6dfb\u52a0\u7528\u6237");
				jbtadd.setBounds(392, 70, 81, 27);
				jbtadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtaddActionPerformed(evt);
					}
				});
			}
			{
				jbtchange = new JButton();
				getContentPane().add(jbtchange);
				jbtchange.setText("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
				jbtchange.setBounds(370, 24, 118, 27);
				jbtchange.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtchangeActionPerformed(evt);
					}
				});
			}
			{
				jtxtsearch = new JTextField();
				getContentPane().add(jtxtsearch);
				jtxtsearch.setBounds(31, 24, 125, 27);
			}
			{
				jbtsearch = new JButton();
				getContentPane().add(jbtsearch);
				jbtsearch.setText("\u59d3\u540d\u67e5\u8be2");
				jbtsearch.setBounds(168, 18, 87, 27);
				jbtsearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtsearchActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(530, 411);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jbtsearchActionPerformed(ActionEvent evt) {
		String tempname = jtxtsearch.getText();
		Vector<Vector> datas2 = new Vector<Vector>();
		Boolean flag = false;
		for (int i = 0; i < jtablepatient.getRowCount(); i++) {
			if(jtablepatient.getValueAt(i, 1).equals(tempname)){
				flag = true;
				datas2.add(datas.get(i));
				
			}
		}
		if(flag){
			
			TableModel jtabadminModel = new DefaultTableModel(datas2,pc.getColNames());
			jtablepatient = new JTable();
			jScrollPane1.setViewportView(jtablepatient);
			jtablepatient.setModel(jtabadminModel);
			TableColumn tc = jtablepatient.getColumnModel().getColumn(0);  
			tc.setCellEditor(jtablepatient.getDefaultEditor(Boolean.class));  
			tc.setCellRenderer(jtablepatient.getDefaultRenderer(Boolean.class));
			tc = jtablepatient.getColumnModel().getColumn(8);
			tc.setCellEditor(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
			tc.setCellRenderer(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
			repaint();
		}else{
			JOptionPane.showMessageDialog(null, "ÇëÊäÈëÕýÈ·µÄÐÕÃû");
		}
	}
	
	private void jbtchangeActionPerformed(ActionEvent evt) {
		Patient patient = new Patient();
		int temp = 0;
		Boolean flag = false;
		try{
			for (int i = 0; i < jtablepatient.getRowCount(); i++) {
			if((Boolean)jtablepatient.getValueAt(i, 0)){
				temp=i;
				patient.setName(jtablepatient.getValueAt(i, 1)+"");
				patient.setBirth(jtablepatient.getValueAt(i, 2)+"");
				patient.setGender(jtablepatient.getValueAt(i, 3)+"");
				patient.setID(jtablepatient.getValueAt(i, 4)+"");
				patient.setPhone(jtablepatient.getValueAt(i, 5)+"");
				patient.setEmergency(jtablepatient.getValueAt(i, 6)+"");
				patient.setEmergencyPhone(jtablepatient.getValueAt(i, 7)+"");
				if(patient.getBirth().length()!=0){
				pc.save(patient,temp);
				flag = true;
				}
				break;
			}
		}	
			if(!flag){
				JOptionPane.showMessageDialog(null, "Çë¹æ·¶²Ù×÷");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Çë¹æ·¶²Ù×÷");
		}
	}

	private ModelControllerImpl md= ModelControllerImpl.getinstance();
	private void jbtmodelListActionPerformed(ActionEvent evt) {
		ModelListView mlv = new ModelListView(md);
		mlv.setLocationRelativeTo(null);
		mlv.setVisible(true);
	}
	
	Vector<Vector> datas1 = new Vector<Vector>();
	private void jbtaddActionPerformed(ActionEvent evt) {
		try{
			pc.add();
		for (Patient pat: pc.query()) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(pat.getName());
			data.add(pat.getBirth());
			data.add(pat.getGender());
			data.add(pat.getID());
			data.add(pat.getPhone());
			data.add(pat.getEmergency());
			data.add(pat.getEmergencyPhone());
			data.add("");
			datas1.add(data);
		}
		TableModel jtabadminModel = new DefaultTableModel(datas1,pc.getColNames());
		jtablepatient = new JTable();
		jScrollPane1.setViewportView(jtablepatient);
		jtablepatient.setModel(jtabadminModel);
		TableColumn tc = jtablepatient.getColumnModel().getColumn(0);  
		tc.setCellEditor(jtablepatient.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(jtablepatient.getDefaultRenderer(Boolean.class));
		tc = jtablepatient.getColumnModel().getColumn(8);
		tc.setCellEditor(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
		tc.setCellRenderer(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
		repaint();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Çë¹æ·¶²Ù×÷");
		}
		
	}
	
	private void jbtpassActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "±£´æ³É¹¦");
	}
	
	private void jbtcloseActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private void jbtdeleteActionPerformed(ActionEvent evt) {
		Vector <Vector> temp = new Vector<Vector>();
		String temp1 =null;
		Patient patient =null;
		try{
			for (int i = 0; i < jtablepatient.getRowCount(); i++) {
			if((Boolean)jtablepatient.getValueAt(i, 0)){
				temp1 = datas.get(i).get(1)+"";
				break;
			}
		}
		for (Patient dp : pc.query()) {
			if(temp1.equals(dp.getName())){
				patient = dp; 
				pc.delete(dp);
				break;
			}
		}
		
		for (int i = 0; i < jtablepatient.getRowCount(); i++) {
			if(!(Boolean)jtablepatient.getValueAt(i, 0)){
				temp.add(datas.get(i));
			}
		}

		TableModel jtabadminModel = new DefaultTableModel(temp,pc.getColNames());
		jtablepatient = new JTable();
		jScrollPane1.setViewportView(jtablepatient);
		jtablepatient.setModel(jtabadminModel);
		TableColumn tc = jtablepatient.getColumnModel().getColumn(0);  
		tc.setCellEditor(jtablepatient.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(jtablepatient.getDefaultRenderer(Boolean.class));
		tc = jtablepatient.getColumnModel().getColumn(8);
		tc.setCellEditor(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
		tc.setCellRenderer(new JTableEmbedJbutton("ÆÀ¹À",admin,md,pc));
		repaint();
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Çë¹æ·¶²Ù×÷");
		}
		
	}

}

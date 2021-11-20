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
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yjz.dao.model.ModelDAO;
import com.yjz.dao.tool.JTableEmbedJbutton;
import com.yjz.model.Admin;
import com.yjz.model.Model;
import com.yjz.model.Patient;
import com.yjz.service.control.ModelController;
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
public class ModelListView extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jbtclose;
	private JComboBox jComboBox1;
	private JButton jbtcreate;
	private JButton jbtdelete;
	private JButton jbtscan;
	private JButton jbtpass;
	private JTable jtableModel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	private ModelControllerImpl md; 	
	public ModelListView(ModelControllerImpl md) {
		this.md = md;
		initGUI();
	}

	Vector <Vector> datas = new Vector<Vector> ();

	private void initGUI() {
		Vector <String> datas1 = new Vector<String>();
		//System.out.println("nihao");
		for (Model mod : md.query()) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(mod.getID());
			data.add(mod.getTitle());
			data.add(mod.getForm());
			datas.add(data);
			datas1.add(mod.getForm());
			//System.out.println(mod.getForm());
			//System.out.println("nihao");
		}
		for (int i=0;i<datas1.size();i++)
	       {
	           for (int j=i+1;j<datas1.size();j++)
	           {
	               if(datas1.get(i).equals(datas1.get(j))){
	                   datas1.remove(j);
	               }
	           }
	       }
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 86, 441, 215);
				{
					TableModel jtableModelModel = 
						new DefaultTableModel(
								datas,
								md.getColNames());
					jtableModel = new JTable();
					jScrollPane1.setViewportView(jtableModel);
					jtableModel.setModel(jtableModelModel);
					TableColumn tc = jtableModel.getColumnModel().getColumn(0);  
					tc.setCellEditor(jtableModel.getDefaultEditor(Boolean.class));  
					tc.setCellRenderer(jtableModel.getDefaultRenderer(Boolean.class));
				}
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u4fdd\u5b58");
				jbtpass.setBounds(78, 313, 89, 27);
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
				jbtclose.setBounds(286, 313, 84, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
					}
				});
			}
			{
				jbtscan = new JButton();
				getContentPane().add(jbtscan);
				jbtscan.setText("\u9884\u89c8");
				jbtscan.setBounds(24, 48, 81, 27);
				jbtscan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtscanActionPerformed(evt);
					}
				});
			}
			{
				jbtdelete = new JButton();
				getContentPane().add(jbtdelete);
				jbtdelete.setText("\u5220\u9664");
				jbtdelete.setBounds(125, 48, 71, 27);
				jbtdelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtdeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtcreate = new JButton();
				getContentPane().add(jbtcreate);
				jbtcreate.setText("\u65b0\u5efa\u6a21\u677f");
				jbtcreate.setBounds(357, 48, 89, 27);
				jbtcreate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcreateActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							datas1);
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(24, 10, 163, 27);
				jComboBox1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jComboBox1ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(490, 398);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jComboBox1ActionPerformed(ActionEvent evt) {
		String temp = jComboBox1.getSelectedItem().toString();
		Vector<Vector> datas2 = new Vector<Vector>();
		for (Vector da : datas) {
			if(temp.equals(da.get(3)+"")){
				datas2.add(da);
			}
		}
		TableModel jtabadminModel = 
			new DefaultTableModel(
					datas2,
					md.getColNames());
		jtableModel = new JTable();
		jScrollPane1.setViewportView(jtableModel);
		jtableModel.setModel(jtabadminModel);
		TableColumn tc = jtableModel.getColumnModel().getColumn(0);  
		tc.setCellEditor(jtableModel.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(jtableModel.getDefaultRenderer(Boolean.class));
	}
	
	private void jbtscanActionPerformed(ActionEvent evt) {
		String tar = "";
		Boolean flag = false;try{
			for (int i = 0; i < jtableModel.getRowCount(); i++) {
				if((Boolean)jtableModel.getValueAt(i, 0)){
					tar = jtableModel.getValueAt(i, 2)+"";
					flag = true;
				}
			}
			if(flag){
				ModelnumListView mlv = new ModelnumListView(md,tar);
				mlv.setLocationRelativeTo(null);
				mlv.setVisible(true);	
			}else{
				JOptionPane.showMessageDialog(null, "请规范操作");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "请规范操作");
		}
	}
	
	private void jbtdeleteActionPerformed(ActionEvent evt) {
		Vector <Vector> temp = new Vector<Vector>();
		String temp1 ="";
		Boolean flag = false;
		try{
			for (int i = 0; i < jtableModel.getRowCount(); i++) {
			if((Boolean)jtableModel.getValueAt(i, 0)){
				temp1 = datas.get(i).get(1)+"";
				break;
			}
		}
		for (Model mod : md.query()) {
			if(temp1.equals(mod.getID())){
				md.delete(mod);
				flag = true;
				break;
			}
		}
		if(flag){
			for (int i = 0; i < jtableModel.getRowCount(); i++) {
			if(!(Boolean)jtableModel.getValueAt(i, 0)){
				temp.add(datas.get(i));
			}
		}

		TableModel jtabadminModel = new DefaultTableModel(temp,md.getColNames());
		jtableModel = new JTable();
		jScrollPane1.setViewportView(jtableModel);
		jtableModel.setModel(jtabadminModel);
		TableColumn tc = jtableModel.getColumnModel().getColumn(0);  
		tc.setCellEditor(jtableModel.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(jtableModel.getDefaultRenderer(Boolean.class));
		repaint();
		}else{
			JOptionPane.showMessageDialog(null, "未进行删除操作");
		}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "请规范操作");
		}
		
	}
	
	private void jbtcreateActionPerformed(ActionEvent evt) {
		Vector <Vector> datas1 = new Vector<Vector>();
		Model temp = new Model(""+(md.query().size()+1),"待定","待定");
		try{
			md.add(temp);
			for (Model mod: md.query()) {
				Vector data = new Vector();
				data.add(new Boolean(false));
				data.add(mod.getID());
				data.add(mod.getTitle());
				data.add(mod.getForm());
				datas1.add(data);
			}
			TableModel jtabadminModel = new DefaultTableModel(datas1,md.getColNames());
			jtableModel = new JTable();
			jScrollPane1.setViewportView(jtableModel);
			jtableModel.setModel(jtabadminModel);
			TableColumn tc = jtableModel.getColumnModel().getColumn(0);  
			tc.setCellEditor(jtableModel.getDefaultEditor(Boolean.class));  
			tc.setCellRenderer(jtableModel.getDefaultRenderer(Boolean.class));
			repaint();		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "请规范操作");
		}
	}
	
	private void jbtpassActionPerformed(ActionEvent evt) {
		Vector temp = new Vector();
		Boolean flag = false;
		try{
			for (int i = 0; i < jtableModel.getRowCount(); i++) {
				if((Boolean) jtableModel.getValueAt(i, 0)){
					temp.add(jtableModel.getValueAt(i, 1));
					temp.add(jtableModel.getValueAt(i, 2));
					temp.add(jtableModel.getValueAt(i, 3));
					flag = true;
				}
			}
			if(flag){
				Model mod = new Model();
				mod.setID(temp.get(0)+"");
				mod.setTitle(temp.get(1)+"");
				mod.setForm(temp.get(2)+"");
				for (Model ml : md.query()) {
					if(ml.getID().equals(md.query().size()+"")){
						md.delete(ml);
						md.add(mod);
						break;
					}
				}		
			}else{
				JOptionPane.showMessageDialog(null, "请规范操作");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "请规范操作");
		}
	}
	
	private void jbtcloseActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

}

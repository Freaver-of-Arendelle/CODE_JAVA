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
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yjz.model.Admin;
import com.yjz.service.control.AdminController;
import com.yjz.service.impl.control.AdminControllerImpl;


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
public class MaxAdminView extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jbtclose;
	private JComboBox jComboBox1;
	private JButton jbtsearch;
	private JTextField jtxtsearch;
	private JButton jbtdeleteAdmin;
	private JButton jbtaddAdmin;
	private JButton jbtpass;
	private JTable jtabadmin;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private AdminControllerImpl ad;	
	public MaxAdminView(AdminControllerImpl ad) {
		this.ad=ad;
		initGUI();
	}
	
	Vector<Vector> datas = new Vector<Vector>();
	Vector<String> datas1 = new Vector<String>();
	private void initGUI() {
		for (Admin admin : ad.query()) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(admin.getUserName());
			data.add(admin.getRealName());
			data.add(admin.getBirth());
			data.add(admin.getMajor());
			data.add(admin.getJob());
			data.add(admin.getPhone());
			datas.add(data);
			datas1.add(admin.getJob());
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
				jScrollPane1.setBounds(12, 108, 486, 175);
				{
					TableModel jtabadminModel = 
						new DefaultTableModel(
								datas,
								ad.getColNames());
					jtabadmin = new JTable();
					jScrollPane1.setViewportView(jtabadmin);
					jtabadmin.setModel(jtabadminModel);
					TableColumn tc = jtabadmin.getColumnModel().getColumn(0);  
					tc.setCellEditor(jtabadmin.getDefaultEditor(Boolean.class));  
					tc.setCellRenderer(jtabadmin.getDefaultRenderer(Boolean.class));

				}
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u4fdd\u5b58");
				jbtpass.setBounds(54, 306, 87, 27);
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
				jbtclose.setBounds(296, 306, 83, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
					}
				});
			}
			{
				jbtaddAdmin = new JButton();
				getContentPane().add(jbtaddAdmin);
				jbtaddAdmin.setText("\u6dfb\u52a0\u5de5\u4f5c\u4eba\u5458");
				jbtaddAdmin.setBounds(394, 70, 104, 27);
				jbtaddAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtaddAdminActionPerformed(evt);
					}
				});
			}
			{
				jbtdeleteAdmin = new JButton();
				getContentPane().add(jbtdeleteAdmin);
				jbtdeleteAdmin.setText("\u5220\u9664");
				jbtdeleteAdmin.setBounds(12, 70, 84, 27);
				jbtdeleteAdmin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtdeleteAdminActionPerformed(evt);
					}
				});
			}
			{
				jtxtsearch = new JTextField();
				getContentPane().add(jtxtsearch);
				jtxtsearch.setBounds(12, 12, 98, 27);
			}
			{
				jbtsearch = new JButton();
				getContentPane().add(jbtsearch);
				jbtsearch.setText("\u59d3\u540d\u67e5\u8be2");
				jbtsearch.setBounds(141, 12, 74, 27);
				jbtsearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtsearchActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(datas1);
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(124, 56, 172, 27);
				jComboBox1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jComboBox1ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(537, 391);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jbtsearchActionPerformed(ActionEvent evt) {
		String tempname = jtxtsearch.getText();
		Vector<Vector> datas2 = new Vector<Vector>();
		Boolean flag = false;
		for (int i = 0; i < jtabadmin.getRowCount(); i++) {
			if(jtabadmin.getValueAt(i, 2).equals(tempname)){
				
				datas2.add(datas.get(i));
				flag = true;
				
			}
		}
		if(flag){
			TableModel jtabadminModel = new DefaultTableModel(datas2,ad.getColNames());
			jtabadmin = new JTable();
			jScrollPane1.setViewportView(jtabadmin);
			jtabadmin.setModel(jtabadminModel);
			TableColumn tc = jtabadmin.getColumnModel().getColumn(0);  
			tc.setCellEditor(jtabadmin.getDefaultEditor(Boolean.class));  
			tc.setCellRenderer(jtabadmin.getDefaultRenderer(Boolean.class));
			repaint();
		}else{
			JOptionPane.showMessageDialog(null, "该用户不存在");
		}
			
	}
	
	private void jbtdeleteAdminActionPerformed(ActionEvent evt) {
		Vector <Vector> temp = new Vector<Vector>();
		String temp1 ="";
		Admin admin = new Admin();
		Boolean flag = false;
		try{
			for (int i = 0; i < jtabadmin.getRowCount(); i++) {
			if((Boolean)jtabadmin.getValueAt(i, 0)){
				temp1 = datas.get(i).get(2)+"";
				flag = true;
				break;
			}
		}
			if(flag){
				for (Admin da : ad.query()) {
					if(temp1.equals(da.getRealName())){
						admin = da; 
						ad.delete(admin);
						break;
					}
				}
				
				for (int i = 0; i < jtabadmin.getRowCount(); i++) {
					if(!(Boolean)jtabadmin.getValueAt(i, 0)){
						temp.add(datas.get(i));
					}
				}
				
				TableModel jtabadminModel = new DefaultTableModel(temp,ad.getColNames());
				jtabadmin = new JTable();
				jScrollPane1.setViewportView(jtabadmin);
				jtabadmin.setModel(jtabadminModel);
				TableColumn tc = jtabadmin.getColumnModel().getColumn(0);  
				tc.setCellEditor(jtabadmin.getDefaultEditor(Boolean.class));  
				tc.setCellRenderer(jtabadmin.getDefaultRenderer(Boolean.class));
				repaint();
				
			}else{
				JOptionPane.showMessageDialog(null, "请选择删除的目标");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "请规范操作");
		}
		
		
		//initGUI();
	}
	
	private void jbtaddAdminActionPerformed(ActionEvent evt) {
		RegisterView rgv = new RegisterView(ad);
		rgv.setLocationRelativeTo(null);
		rgv.setVisible(true);
	}
	
	private void jbtpassActionPerformed(ActionEvent evt) {
		Admin admin = new Admin();
		int temp = 0;
		Boolean flag = false;
		try{
			for (int i = 0; i < jtabadmin.getRowCount(); i++) {
			if((Boolean)jtabadmin.getValueAt(i, 0)){
				temp=i;
				admin.setAccount(ad.query().get(i).getAccount());
				admin.setPassword(ad.query().get(i).getPassword());
				admin.setUserName(jtabadmin.getValueAt(i, 1)+"");
				admin.setRealName(jtabadmin.getValueAt(i, 2)+"");
				admin.setBirth(jtabadmin.getValueAt(i, 3)+"");
				admin.setMajor(jtabadmin.getValueAt(i, 4)+"");
				admin.setJob(jtabadmin.getValueAt(i, 5)+"");
				admin.setPhone(jtabadmin.getValueAt(i, 6)+"");
				ad.save(admin,temp);
				flag = true;
				break;
			}
		}
		if(flag){
			JOptionPane.showMessageDialog(null, "保存成功");
		}else{
			JOptionPane.showMessageDialog(null, "保存失败");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void jbtcloseActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private void jComboBox1ActionPerformed(ActionEvent evt) {
		//下拉列表选择
		String temp = jComboBox1.getSelectedItem().toString();
		Vector<Vector> datas2 = new Vector<Vector>();
		for (Vector da : datas) {
			if(temp.equals(da.get(5)+"")){
				datas2.add(da);
			}
		}
		TableModel jtabadminModel = 
			new DefaultTableModel(
					datas2,
					ad.getColNames());
		jtabadmin = new JTable();
		jScrollPane1.setViewportView(jtabadmin);
		jtabadmin.setModel(jtabadminModel);
		TableColumn tc = jtabadmin.getColumnModel().getColumn(0);  
		tc.setCellEditor(jtabadmin.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(jtabadmin.getDefaultRenderer(Boolean.class));
	}

}

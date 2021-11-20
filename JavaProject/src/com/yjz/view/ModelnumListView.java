package com.yjz.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yjz.model.Model;
import com.yjz.model.Patient;
import com.yjz.model.Question;
import com.yjz.service.impl.control.ModelControllerImpl;
import com.yjz.service.impl.control.QuestionControllerImpl;;

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
public class ModelnumListView extends javax.swing.JFrame {
	private JLabel jblmodel;
	private JScrollPane jScrollPane1;
	private JButton jbtdelete;
	private JButton jbtclose;
	private JButton jbtadd;
	private JTable ModelNumtb;

	/**
	* Auto-generated main method to display this JFrame
	*/
	ModelControllerImpl mci;
	String target;
	public ModelnumListView(ModelControllerImpl mci,String tar) {
		this.mci=mci;
		this.target = tar;
		initGUI();
	}
	Vector<Vector> datas = new Vector<Vector>();
	private void initGUI() {
		for (Model mod : mci.query()) {
			if(mod.getTitle().equals(target)){
				for (int i = 0; i < mod.getQinm().size(); i++) {
					Vector data = new Vector();
					data.add(new Boolean(false));
					data.add(mod.getQinm().get(i).getID());
					data.add(mod.getQinm().get(i).getQuestion());
					datas.add(data);
				}
				break;
			}
		}
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jblmodel = new JLabel();
				getContentPane().add(jblmodel);
				jblmodel.setText(target);
				jblmodel.setBounds(24, 47, 56, 26);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 92, 406, 187);
				{
					TableModel ModelNumtbModel = 
						new DefaultTableModel(
								datas,
						mci.getScanColnames());
					ModelNumtb = new JTable();
					jScrollPane1.setViewportView(ModelNumtb);
					ModelNumtb.setModel(ModelNumtbModel);
					TableColumn tc = ModelNumtb.getColumnModel().getColumn(0);  
					tc.setCellEditor(ModelNumtb.getDefaultEditor(Boolean.class));  
					tc.setCellRenderer(ModelNumtb.getDefaultRenderer(Boolean.class));
				}
			}
			{
				jbtadd = new JButton();
				getContentPane().add(jbtadd);
				jbtadd.setText("\u6dfb\u52a0");
				jbtadd.setBounds(317, 54, 80, 27);
				jbtadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtaddActionPerformed(evt);
					}
				});
			}
			{
				jbtdelete = new JButton();
				getContentPane().add(jbtdelete);
				jbtdelete.setText("\u5220\u9664");
				jbtdelete.setBounds(50, 291, 96, 27);
				jbtdelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtdeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtclose = new JButton();
				getContentPane().add(jbtclose);
				jbtclose.setText("\u8fd4\u56de");
				jbtclose.setBounds(286, 291, 87, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(448, 386);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private QuestionControllerImpl qci = QuestionControllerImpl.getinstance();
	private void jbtaddActionPerformed(ActionEvent evt) {
		QuestionView qv = new QuestionView(qci,mci,target);
		qv.setLocationRelativeTo(null);
		qv.setVisible(true);
	}
	
	private void jbtcloseActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private void jbtdeleteActionPerformed(ActionEvent evt) {
		Vector <Vector> temp = datas;
		String temp1 ="";
		Model model = new Model();
		Boolean flag = false;
		for (int i = 0; i < ModelNumtb.getRowCount(); i++) {
			if((Boolean)ModelNumtb.getValueAt(i, 0)){
				temp1 = datas.get(i).get(1)+"";
				temp.remove(i);
				flag = true;
				break;
			}
		}
		if(flag){
			
			for (int i = 0; i < mci.query().size(); i++) {
				for (int j = 0; j < mci.query().get(i).getQinm().size(); j++) {
					if(temp1.equals(mci.query().get(i).getQinm().get(j).getID())){
						model = mci.query().get(i);
						Question ques = mci.query().get(i).getQinm().get(j);
						mci.delete(model, ques);
					}
				}
			}
			TableModel jtabadminModel = new DefaultTableModel(temp,mci.getScanColnames());
			ModelNumtb = new JTable();
			jScrollPane1.setViewportView(ModelNumtb);
			ModelNumtb.setModel(jtabadminModel);
			TableColumn tc = ModelNumtb.getColumnModel().getColumn(0);  
			tc.setCellEditor(ModelNumtb.getDefaultEditor(Boolean.class));  
			tc.setCellRenderer(ModelNumtb.getDefaultRenderer(Boolean.class));
		}else{
			JOptionPane.showMessageDialog(null, "模板内无问题");
		}

	}

}

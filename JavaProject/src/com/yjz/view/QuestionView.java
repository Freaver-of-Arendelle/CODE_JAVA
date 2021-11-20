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

import com.yjz.dao.tool.JTableEmbedJbutton;
import com.yjz.model.Model;
import com.yjz.model.Patient;
import com.yjz.model.Question;
import com.yjz.service.impl.control.ModelControllerImpl;
import com.yjz.service.impl.control.QuestionControllerImpl;


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
public class QuestionView extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jbtdelete;
	private JButton jbtthorough;
	private JButton jbtclose;
	private JComboBox jComboBox1;
	private JButton jbtpass;
	private JButton jbtadd;
	private JTable jtbquestion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	private QuestionControllerImpl qci;
	private ModelControllerImpl mci;
	private String target;
	public QuestionView(QuestionControllerImpl qci,ModelControllerImpl mci,String target) {
		this.qci= qci;
		this.mci= mci;
		this.target=target;
		initGUI();
	}
	Vector<Vector> datas = new Vector<Vector>();
	private JButton jbtchange;
	private void initGUI() {
		Vector<String> datas1 = new Vector<String>();
		System.out.println(qci.query().size());
		for (Question ques : qci.query()) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(ques.getID());
			data.add(ques.getQuestion());
			data.add(ques.getForm());
			datas.add(data);
			datas1.add(ques.getForm());
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
				jScrollPane1.setBounds(35, 83, 387, 209);
				{
					TableModel jtbquestionModel = 
						new DefaultTableModel(
								datas,
								qci.getColnames());
					jtbquestion = new JTable();
					jScrollPane1.setViewportView(jtbquestion);
					jtbquestion.setModel(jtbquestionModel);
					TableColumn tc = jtbquestion.getColumnModel().getColumn(0);  
					tc.setCellEditor(jtbquestion.getDefaultEditor(Boolean.class));  
					tc.setCellRenderer(jtbquestion.getDefaultRenderer(Boolean.class));
				}
			}
			{
				jbtdelete = new JButton();
				getContentPane().add(jbtdelete);
				jbtdelete.setText("\u5220\u9664");
				jbtdelete.setBounds(25, 45, 93, 27);
				jbtdelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtdeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtthorough = new JButton();
				getContentPane().add(jbtthorough);
				jbtthorough.setText("\u8be6\u60c5");
				jbtthorough.setBounds(209, 45, 84, 27);
				jbtthorough.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtthoroughActionPerformed(evt);
					}
				});
			}
			{
				jbtadd = new JButton();
				getContentPane().add(jbtadd);
				jbtadd.setText("\u65b0\u589e");
				jbtadd.setBounds(333, 45, 80, 27);
				jbtadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtaddActionPerformed(evt);
					}
				});
			}
			{
				jbtpass = new JButton();
				getContentPane().add(jbtpass);
				jbtpass.setText("\u6dfb\u52a0");
				jbtpass.setBounds(35, 308, 89, 27);
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
				jbtclose.setBounds(293, 308, 85, 27);
				jbtclose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtcloseActionPerformed(evt);
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
				jComboBox1.setBounds(25, 7, 108, 27);
				jComboBox1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jComboBox1ActionPerformed(evt);
					}
				});
			}
			{
				jbtchange = new JButton();
				getContentPane().add(jbtchange);
				jbtchange.setText("\u4fee\u6539");
				jbtchange.setBounds(275, 7, 85, 27);
				jbtchange.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtchangeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(474, 393);
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
					qci.getColnames());
		jtbquestion = new JTable();
		jScrollPane1.setViewportView(jtbquestion);
		jtbquestion.setModel(jtabadminModel);
		TableColumn tc = jtbquestion.getColumnModel().getColumn(0);  
		tc.setCellEditor(jtbquestion.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(jtbquestion.getDefaultRenderer(Boolean.class));
	}
	
	private void jbtdeleteActionPerformed(ActionEvent evt) {
		Vector <Vector> temp = new Vector<Vector>();
		Vector <Vector> temp1 = new Vector<Vector>();
		Boolean flag = false;
		for (int i = 0; i < jtbquestion.getRowCount(); i++) {
			if((Boolean)jtbquestion.getValueAt(i, 0)){
				temp1.add(datas.get(i));
				flag = true;
			}
			if(!(Boolean)jtbquestion.getValueAt(i, 0)){
				temp.add(datas.get(i));
			}
		}
		if(flag){
			for (int i = 0; i < qci.query().size(); i++) {
				for (int j = 0; j < temp1.size(); j++) {
					if(qci.query().get(i).getID().equals(temp1.get(j).get(1)+"")){
						qci.delete(qci.query().get(i));
					}
				}
			}	
			//不清楚
			for (int j2 = 0; j2 < temp1.size(); j2++) {
				for (int i = 0; i < mci.query().size(); i++) {
					for (int j = 0; j < mci.query().get(i).getQinm().size(); j++) {
						if(mci.query().get(i).getQinm().get(j).getID().equals(temp1.get(j2).get(1)+"")){
							Question question = mci.query().get(i).getQinm().get(j);
							Model model = mci.query().get(i);
							mci.delete(model, question);
						}
					}
				}
			}
			
			
			TableModel jtabadminModel = new DefaultTableModel(temp,qci.getColnames());
			jtbquestion = new JTable();
			jScrollPane1.setViewportView(jtbquestion);
			jtbquestion.setModel(jtabadminModel);
			TableColumn tc = jtbquestion.getColumnModel().getColumn(0);  
			tc.setCellEditor(jtbquestion.getDefaultEditor(Boolean.class));  
			tc.setCellRenderer(jtbquestion.getDefaultRenderer(Boolean.class));
			repaint();
		}else{
			JOptionPane.showMessageDialog(null, "请规范操作");
		}
		
	}
	
	private void jbtthoroughActionPerformed(ActionEvent evt) {
		Vector<String> colnames = new Vector<String>();
		Vector<Vector> temp = new Vector<Vector>();
		Boolean flag = false;
		for (int i = 0; i < jtbquestion.getRowCount(); i++) {
			if((Boolean)jtbquestion.getValueAt(i, 0)){
				String str = jtbquestion.getValueAt(i, 1)+"";
				for (Question question : qci.query()) {
					if(question.getID().equals(str)){
						Vector tem = new Vector();
						tem.add(question.getID());
						tem.add(question.getAnswer1());
						tem.add(question.getAnswer2());
						tem.add(question.getAnswer3());
						temp.add(tem);
					}
				}
				flag = true;
			}
		}
		if(flag){
		colnames.add("ID");
		colnames.add("答案一");
		colnames.add("答案二");
		colnames.add("答案三");
		TableModel jtabadminModel = new DefaultTableModel(temp,colnames);
		jtbquestion = new JTable();
		jScrollPane1.setViewportView(jtbquestion);
		jtbquestion.setModel(jtabadminModel);
		}else{
			JOptionPane.showMessageDialog(null, "请规范操作");
		}
	}
	
	private void jbtaddActionPerformed(ActionEvent evt) {
		QuestionaddView qav = new QuestionaddView(qci);
		qav.setLocationRelativeTo(null);
		qav.setVisible(true);
	}
	
	private void jbtpassActionPerformed(ActionEvent evt) {
		Model tem = new Model();//不重复添加
		int k = 0;
		for (Model mod : mci.query()) {
			if(mod.getTitle().equals(target)){
				tem = mod;
			}
		}
		for (int i = 0; i < jtbquestion.getRowCount(); i++) {
			if((Boolean) jtbquestion.getValueAt(i, 0)){
				String temp = jtbquestion.getValueAt(i, 1)+"";
				for (Question q : tem.getQinm()) {
					if(q.getID().equals(temp)){
						k = 1;
					}
				}
				if(k == 0){
					for (Question que : qci.query()) {
						if(que.getID().equals(temp)){
							mci.add(tem, que);
						}
					}		
				}
				if(k == 1){
					JOptionPane.showMessageDialog(null, "不重复添加");
				}
			}
		}
	}
	
	private void jbtcloseActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private void jbtchangeActionPerformed(ActionEvent evt) {
		int temp1 = 0;
		String temp = "";
		for (int i = 0; i < jtbquestion.getRowCount(); i++) {
			if((Boolean)jtbquestion.getValueAt(i, 0)){
				temp1++;
				temp = jtbquestion.getValueAt(i, 1)+"";
			}
		}
		if(temp1==1){
			
			QuestionchangeView qcv = new QuestionchangeView(qci,mci,temp);
			qcv.setLocationRelativeTo(null);
			qcv.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "只能修改一次问题");
		}
	}

}

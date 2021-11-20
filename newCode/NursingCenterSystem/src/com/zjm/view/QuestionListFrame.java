package com.zjm.view;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.zjm.model.Question;
import com.zjm.model.QuestionModel;
import com.zjm.service.impl.controller.QuestionControllerImpl;
import com.zjm.service.impl.controller.QuestionModelControllerImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class QuestionListFrame extends javax.swing.JFrame {
	private JScrollPane jspShow;
	private JTable tblShowQues;
	private JButton btnDelete;
	private JButton btnDetail;
	private JButton btnAdd;
	private JComboBox jComboBox1;
	private JButton btnBack;
	private JButton btnAddQues;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public QuestionListFrame() {
		super();
		initGUI();
	}
	private Vector<String> types;
	public QuestionListFrame(QuestionModel qm) {
		super();
		this.qci = QuestionControllerImpl.getinstance();
		this.qm = qm;
		this.types = new Vector<String>();
		types.add("");
		this.qmci = QuestionModelControllerImpl.getinstance();
		datas = loadData();
		initGUI();
	}
	
	
	private QuestionControllerImpl qci;
	private QuestionModel qm;
	private QuestionModelControllerImpl qmci;
	private Vector<Vector> datas;
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jspShow = new JScrollPane();
				getContentPane().add(jspShow);
				jspShow.setBounds(12, 104, 518, 226);
				{
					paintTable(datas);
				}
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(12, 61, 76, 27);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			{
				btnDetail = new JButton();
				getContentPane().add(btnDetail);
				btnDetail.setText("\u8be6\u60c5");
				btnDetail.setBounds(323, 61, 68, 27);
				btnDetail.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDetailActionPerformed(evt);
					}
				});
			}
			{
				btnAddQues = new JButton();
				getContentPane().add(btnAddQues);
				btnAddQues.setText("\u65b0\u589e");
				btnAddQues.setBounds(403, 61, 68, 27);
				btnAddQues.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddQuesActionPerformed(evt);
					}
				});
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u6dfb\u52a0");
				btnAdd.setBounds(102, 340, 68, 27);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(306, 342, 68, 27);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(types);
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(24, 17, 107, 27);
				jComboBox1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jComboBox1ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(560, 425);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/*
	 * 加载表格数据
	 */
	private Vector<Vector> loadData() {
		Vector<Vector> datas = new Vector<Vector>();
		Vector<Question> ques = qci.query();
		for (Question question : ques) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(question.getId());
			data.add(question.getQuestion());
			data.add(question.getType());
			if (!types.contains(question.getType())) {
				
				types.add(question.getType());
			}
			datas.add(data);
			
		}
		return datas;
	}
	private void paintTable(Vector<Vector> datas) {
		TableModel tblShowQuesModel = 
			new DefaultTableModel(datas,qci.getColNames());
		tblShowQues = new JTable();
		jspShow.setViewportView(tblShowQues);
		tblShowQues.setModel(tblShowQuesModel);
		TableColumn tc = tblShowQues.getColumnModel().getColumn(0);  
		tc.setCellEditor(tblShowQues.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(tblShowQues.getDefaultRenderer(Boolean.class));
	}
	
	private void btnDeleteActionPerformed(ActionEvent evt) {
		List<Question> selectedQues = new Vector<Question>();
		types = new Vector<String>();
		types.add("");
		for (int i = 0; i < tblShowQues.getRowCount(); i++) {
			if ((Boolean)tblShowQues.getValueAt(i,0)) {
				selectedQues.add(qci.getQuestion(tblShowQues.getValueAt(i,1).toString()));
			}else if (!types.contains(tblShowQues.getValueAt(i,1).toString())) {	
				types.add(tblShowQues.getValueAt(i,1).toString());
			}

		}
		
		for (Question ques : selectedQues) {
			qci.delete(ques);
		}
		ComboBoxModel jComboBox1Model = 
			new DefaultComboBoxModel(types);
		jComboBox1.setModel(jComboBox1Model);
		qci.save();
		qmci.save();
		datas = loadData();
		paintTable(datas);
	}
	
	private void btnDetailActionPerformed(ActionEvent evt) {
		Question selectedQuestion = null;
		for (int i = 0; i < tblShowQues.getRowCount(); i++) {
			if ((Boolean)tblShowQues.getValueAt(i,0)) {
				selectedQuestion = qci.getQuestion(tblShowQues.getValueAt(i,1).toString());
			}
		}
		QuesDetailFrame qdf = new QuesDetailFrame(selectedQuestion);
		qdf.setLocationRelativeTo(null);
		qdf.setVisible(true);
	}
	
	private void btnAddQuesActionPerformed(ActionEvent evt) {
		QuesAddFrame qaf = new QuesAddFrame(qm);
		qaf.setLocationRelativeTo(null);
		qaf.setVisible(true);
		this.dispose();
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		List<Question> selectedQues = new Vector<Question>();
		for (int i = 0; i < tblShowQues.getRowCount(); i++) {
			if ((Boolean)tblShowQues.getValueAt(i,0)) {
				selectedQues.add(qci.getQuestion(tblShowQues.getValueAt(i,1).toString()));
			}
		}
		for (Question question : selectedQues) {
			qm.addQuestion(question);
		}
		qmci.save();
		QuesModelPreviewFrame qmlf = new QuesModelPreviewFrame(qm);
		qmlf.setLocationRelativeTo(null);
		qmlf.setVisible(true);
		this.dispose();
	}
	
	private void jComboBox1ActionPerformed(ActionEvent evt) {
		String selected = this.jComboBox1.getSelectedItem().toString();
		Vector<Vector> resultDatas = new Vector<Vector>();
		if (selected.equals("")) {
			paintTable(datas);
		}else {
			for (Vector data : datas) {
				if (data.get(3)!=null&&((String)data.get(3)).trim().equals(selected)) {
					resultDatas.add(data);
				}
			}
			paintTable(resultDatas);
		}
	}

}

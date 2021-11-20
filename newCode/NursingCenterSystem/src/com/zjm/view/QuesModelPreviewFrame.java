package com.zjm.view;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
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
public class QuesModelPreviewFrame extends javax.swing.JFrame {
	private JLabel lblName;
	private JScrollPane jspShow;
	private JButton btnAdd;
	private JTable tblShowQues;
	private JButton btnBack;
	private JButton btnDelete;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public QuesModelPreviewFrame() {
		super();
		initGUI();
	}
	
	private QuestionModel qm;
	private QuestionControllerImpl qci;
	private QuestionModelControllerImpl qmci;
	private Vector<Vector> datas;
	private Vector<String> colNames = new Vector<String>();
	public QuesModelPreviewFrame(QuestionModel qm) {
		super();
		this.qm = qm;
		this.qci = QuestionControllerImpl.getinstance();
		this.qmci = QuestionModelControllerImpl.getinstance();
		this.datas = loadData();
		this.colNames.add("");
		this.colNames.add("ID");
		this.colNames.add("题目");

		initGUI();
	}
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				lblName = new JLabel();
				getContentPane().add(lblName);
				lblName.setBounds(18, 28, 70, 28);
				lblName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			}
			{	jspShow = new JScrollPane();
				getContentPane().add(jspShow);
				jspShow.setBounds(18, 102, 512, 214);
				{					
					paintTable(datas);
				}
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u6dfb\u52a0");
				btnAdd.setBounds(407, 64, 89, 27);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(103, 328, 89, 27);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(346, 328, 89, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			lblName.setText(qm.getName());
			pack();
			this.setSize(560, 425);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private void paintTable(Vector<Vector> datas) {
		TableModel tblShowQuesModel = 
				new DefaultTableModel(datas,colNames);
		tblShowQues = new JTable();
		jspShow.setViewportView(tblShowQues);
		tblShowQues.setModel(tblShowQuesModel);
		TableColumn tc = tblShowQues.getColumnModel().getColumn(0);  
		tc.setCellEditor(tblShowQues.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(tblShowQues.getDefaultRenderer(Boolean.class));
	}
	/*
	 * 加载表格数据
	 */
	private Vector<Vector> loadData() {
		Vector<Vector> datas = new Vector<Vector>();
		Vector<Question> questions = qm.getQuestions();
		for (Question question : questions) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(question.getId());
			data.add(question.getQuestion());
			datas.add(data);
			
		}
		return datas;
	}
	
	private void btnDeleteActionPerformed(ActionEvent evt) {
		List<Question> selectedQues = new Vector<Question>();
		for (int i = 0; i < tblShowQues.getRowCount(); i++) {
			if ((Boolean)tblShowQues.getValueAt(i,0)) {
				selectedQues.add(qm.getQuestion(tblShowQues.getValueAt(i,1).toString()));
			}
		}
		for (Question ques : selectedQues) {
			qm.getQuestions().remove(ques);
		}
		qmci.save();
		datas = loadData();
		paintTable(datas);
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		QuestionListFrame qlf = new QuestionListFrame(qm);
		qlf.setLocationRelativeTo(null);
		qlf.setVisible(true);
		this.dispose();
	}
	
	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

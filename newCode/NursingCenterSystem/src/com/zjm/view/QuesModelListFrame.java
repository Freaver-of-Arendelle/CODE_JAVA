package com.zjm.view;

import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.zjm.model.Patient;
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
public class QuesModelListFrame extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	private JComboBox jComboBox1;
	private JButton btnAdd;
	private JTable tblShowQuesModel;
	private JButton btnBack;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnPreview;
	private JScrollPane jspShow;
	
	public QuesModelListFrame() {
		super();
		this.qmci = QuestionModelControllerImpl.getinstance();
		this.types = new Vector<String>();
		types.add("");
		this.datas = loadData();
		this.qci = QuestionControllerImpl.getinstance();
		initGUI();
	}

	private QuestionModelControllerImpl qmci;
	private Vector<Vector> datas;	
	private QuestionControllerImpl qci;
	private Vector<String> types;
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jspShow = new JScrollPane();
				getContentPane().add(jspShow);
				jspShow.setBounds(12, 93, 518, 242);
				jspShow.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				{
					paintTable(datas);
				}
			}
			{
				btnPreview = new JButton();
				getContentPane().add(btnPreview);
				btnPreview.setText("\u9884\u89c8");
				btnPreview.setBounds(12, 55, 69, 27);
				btnPreview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnPreviewActionPerformed(evt);
					}
				});
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(99, 55, 69, 27);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			{
				btnAdd = new JButton();
				getContentPane().add(btnAdd);
				btnAdd.setText("\u65b0\u5efa\u6a21\u677f");
				btnAdd.setBounds(377, 55, 105, 27);
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddActionPerformed(evt);
					}
				});
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(105, 340, 76, 27);
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSaveActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(328, 340, 76, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(types);
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(12, 17, 156, 27);
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

	private void paintTable(Vector<Vector> datas) {
		TableModel tblShowQuesModelModel = 
			new DefaultTableModel(datas,qmci.getColNames());
		tblShowQuesModel = new JTable();
		jspShow.setViewportView(tblShowQuesModel);
		tblShowQuesModel.setModel(tblShowQuesModelModel);
		TableColumn tc = tblShowQuesModel.getColumnModel().getColumn(0);  
		tc.setCellEditor(tblShowQuesModel.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(tblShowQuesModel.getDefaultRenderer(Boolean.class));
	}
	
//	private void loadCombox(Vector<Vector> datas){
//		
//	}

	/*
	 * 加载表格数据
	 */
	private Vector<Vector> loadData() {
		Vector<Vector> datas = new Vector<Vector>();
		Vector<QuestionModel> quesMdl = qmci.query();
		for (QuestionModel questionmodel : quesMdl) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(questionmodel.getId());
			data.add(questionmodel.getName());
			data.add(questionmodel.getType());
			if (!types.contains(questionmodel.getType())) {
				
				types.add(questionmodel.getType());
			}
			datas.add(data);
			
		}
		return datas;
	}
	
	private void btnDeleteActionPerformed(ActionEvent evt) {
		Vector<QuestionModel> qmds = qmci.query();
		List<QuestionModel> selectedQuesModels = new Vector<QuestionModel>();
		for (int i = 0; i < tblShowQuesModel.getRowCount(); i++) {
			if ((Boolean)tblShowQuesModel.getValueAt(i,0)) {
				selectedQuesModels.add(qmci.getQuesModel(tblShowQuesModel.getValueAt(i,1).toString()));
			}
		}
		for (QuestionModel quesModel : selectedQuesModels) {
			qmci.delete(quesModel);
		}
		datas = loadData();
		paintTable(datas);
	}
	
	private void btnSaveActionPerformed(ActionEvent evt) {
		Vector<QuestionModel> qmds = qmci.query();
		types = new Vector<String>();
		types.add("");
		for (int i = 0; i < tblShowQuesModel.getRowCount(); i++) {
			Vector data = new Vector();
			QuestionModel qm = qmci.getQuesModel(tblShowQuesModel.getValueAt(i,1).toString());
//			pti.setName((String) tblShowPatients.getValueAt(i, 1));
			qm.setName((String)tblShowQuesModel.getValueAt(i, 2));
			qm.setType((String) tblShowQuesModel.getValueAt(i, 3));
			if (!types.contains((String) tblShowQuesModel.getValueAt(i, 3))) {
				
				types.add((String) tblShowQuesModel.getValueAt(i, 3));
			}
			
		}
		ComboBoxModel jComboBox1Model = 
			new DefaultComboBoxModel(types);
		jComboBox1.setModel(jComboBox1Model);
		qmci.save();
		datas = loadData();
		paintTable(datas);
	}
	
	private void btnPreviewActionPerformed(ActionEvent evt) {
		for (int i = 0; i < tblShowQuesModel.getRowCount(); i++) {
			if ((Boolean)tblShowQuesModel.getValueAt(i,0)) {
				QuesModelPreviewFrame qmpf = new QuesModelPreviewFrame(qmci.getQuesModel(tblShowQuesModel.getValueAt(i,1).toString()));
				qmpf.setLocationRelativeTo(null);
				qmpf.setVisible(true);
			}
		}
	}
	
	private void btnAddActionPerformed(ActionEvent evt) {
		QuesModelAddFrame qmaf = new QuesModelAddFrame();
		qmaf.setLocationRelativeTo(null);
		qmaf.setVisible(true);
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
	
	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}
}

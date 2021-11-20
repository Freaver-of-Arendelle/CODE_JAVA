package com.zjm.view;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.zjm.model.History;
import com.zjm.model.Patient;
import com.zjm.model.QuestionModel;
import com.zjm.model.Worker;
import com.zjm.service.impl.controller.HistoryControllerImpl;
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
public class EvaluateFrame extends javax.swing.JFrame {
	private JScrollPane jspShow;
	private JTable tblShowHistory;
	private JComboBox jComboBox1;
	private JButton btnClose;
	private JButton tbnStart;

	/**
	* Auto-generated main method to display this JFrame
	*/
	QuestionModelControllerImpl qmci = QuestionModelControllerImpl.getinstance();
	private Patient p;
	private Worker currWorker;
	private HistoryControllerImpl hci = HistoryControllerImpl.getinstance();
	private Vector<String> names;
	public EvaluateFrame(Patient p,Worker currWorker) {
		super();
		this.p = p;
		this.currWorker = currWorker;
		this.names = new Vector<String>();
		names.add("");
		datas = loadData();
		initGUI();
	}
	
	public EvaluateFrame() {
		super();
		this.p = p;
		initGUI();
	}
	private Vector<Vector> datas;
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jspShow = new JScrollPane();
				getContentPane().add(jspShow);
				jspShow.setBounds(12, 79, 518, 242);
				{
					paintTable(datas);
				}
			}
			{
				tbnStart = new JButton();
				getContentPane().add(tbnStart);
				tbnStart.setText("\u5f00\u59cb\u8bc4\u4f30");
				tbnStart.setBounds(17, 41, 92, 27);
				tbnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						tbnStartActionPerformed(evt);
					}
				});
			}
			{
				btnClose = new JButton();
				getContentPane().add(btnClose);
				btnClose.setText("\u5173\u95ed");
				btnClose.setBounds(406, 333, 90, 27);
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCloseActionPerformed(evt);
					}
				});
			}
			{
				
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(names);
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(418, 30, 97, 27);
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
		TableModel tblShowHistoryModel = 
			new DefaultTableModel(datas,hci.getColNames());
		tblShowHistory = new JTable();
		jspShow.setViewportView(tblShowHistory);
		tblShowHistory.setModel(tblShowHistoryModel);
	}
	
	private Vector<Vector> loadData() {
		Vector<Vector> datas = new Vector<Vector>();
		Vector<History> hits = hci.query();
		for (History history : hits) {
			Vector data = new Vector();
			data.add(history.getName());
			data.add(history.getGender());
			data.add(history.getModelName());
			data.add(history.getModelType());
			data.add(history.getTime());
			data.add(history.getEvaluatedBy());
			data.add(history.getAdvice());
			if (!names.contains(history.getModelName())) {
				
				names.add(history.getModelName());
			}
			datas.add(data);
			
		}
		return datas;
	}
	
	private void tbnStartActionPerformed(ActionEvent evt) {
		Vector<QuestionModel> a = qmci.query();
		for (QuestionModel qm : a) {
			if (qm.getName().equals(this.jComboBox1.getSelectedItem().toString())) {
				TestFrame tf = new TestFrame(qm,p,currWorker);
				tf.setLocationRelativeTo(null);
				tf.setVisible(true);
				this.dispose();
			}
		}
		
	}
	
	private void btnCloseActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	private void jComboBox1ActionPerformed(ActionEvent evt) {
		String selected = this.jComboBox1.getSelectedItem().toString();
		Vector<Vector> resultDatas = new Vector<Vector>();
		if (selected.equals("")) {
			paintTable(datas);
		}else {
			for (Vector data : datas) {
				if (data.get(2)!=null&&((String)data.get(2)).trim().equals(selected)) {
					resultDatas.add(data);
				}
			}
			paintTable(resultDatas);
		}
	}

}

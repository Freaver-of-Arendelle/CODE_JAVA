package com.zjm.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.zjm.dao.table.JTableEmbedJbutton;
import com.zjm.model.Patient;
import com.zjm.model.Worker;
import com.zjm.service.controller.PatientController;
import com.zjm.service.controller.WorkerController;
import com.zjm.service.impl.controller.PatientControllerImpl;
import com.zjm.service.impl.controller.QuestionControllerImpl;
import com.zjm.service.impl.controller.WorkerControllerImpl;


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
public class WorkerFrame extends javax.swing.JFrame {
	private JTextField txtSearchName;
	private JButton btnSearchName;
	private JTable tblShowPatients;
	private JButton btnBack;
	private JButton btnEdit;
	private JButton btnAddUser;
	private JButton btnModelList;
	private JButton btnDelete;
	private JButton btnSave;
	private JScrollPane jspShowPatients;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public WorkerFrame() {
		super();
		this.pci = PatientControllerImpl.getinstance();
		datas = loadData();
		initGUI();
	}
	
	public WorkerFrame(Worker currWorker) {
		super();
		this.pci = PatientControllerImpl.getinstance();
		this.wci = WorkerControllerImpl.getinstance();
		this.currWorker = currWorker;
		datas = loadData();
		initGUI();
	}
	private WorkerControllerImpl wci;
	private Worker currWorker;
	private QuestionControllerImpl qci = QuestionControllerImpl.getinstance();

	
	private PatientControllerImpl pci;
	private Vector<Vector> datas;
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				txtSearchName = new JTextField();
				getContentPane().add(txtSearchName);
				txtSearchName.setBounds(12, 12, 101, 27);
			}
			{
				btnSearchName = new JButton();
				getContentPane().add(btnSearchName);
				btnSearchName.setText("\u59d3\u540d\u67e5\u8be2");
				btnSearchName.setBounds(125, 12, 101, 27);
				btnSearchName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSearchNameActionPerformed(evt);
					}
				});
			}
			{
				jspShowPatients = new JScrollPane();
				getContentPane().add(jspShowPatients);
				jspShowPatients.setBounds(12, 100, 568, 207);
				jspShowPatients.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				{
					paintTable(datas);
				}
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(90, 315, 70, 27);
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
				btnBack.setBounds(368, 315, 70, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(14, 62, 76, 27);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			{
				btnModelList = new JButton();
				getContentPane().add(btnModelList);
				btnModelList.setText("\u6a21\u677f\u5217\u8868");
				btnModelList.setBounds(292, 62, 102, 27);
				btnModelList.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnModelListActionPerformed(evt);
					}
				});
			}
			{
				btnAddUser = new JButton();
				getContentPane().add(btnAddUser);
				btnAddUser.setText("\u6dfb\u52a0\u7528\u6237");
				btnAddUser.setBounds(420, 62, 102, 27);
				btnAddUser.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddUserActionPerformed(evt);
					}
				});
			}
			{
				btnEdit = new JButton();
				getContentPane().add(btnEdit);
				btnEdit.setText("\u4fee\u6539\u4e2a\u4eba\u4fe1\u606f");
				btnEdit.setBounds(346, 24, 150, 27);
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnEditActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(610, 401);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private void paintTable(Vector<Vector> datas) {
		TableModel tblShowPatientsModel = 
			new DefaultTableModel(datas,pci.getColNames());
		tblShowPatients = new JTable();
		jspShowPatients.setViewportView(tblShowPatients);
		tblShowPatients.setModel(tblShowPatientsModel);
		TableColumn tc = tblShowPatients.getColumnModel().getColumn(0);  
		tc.setCellEditor(tblShowPatients.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(tblShowPatients.getDefaultRenderer(Boolean.class));
		tc = tblShowPatients.getColumnModel().getColumn(8);
//		tblShowPatients.setc
//		String name = tblShowPatients.getValueAt(, 1)
		tc.setCellEditor(new JTableEmbedJbutton("评估",datas,currWorker));  
		tc.setCellRenderer(new JTableEmbedJbutton("评估",datas,currWorker));
	}
	
	/*
	 * 加载表格数据
	 */
	private Vector<Vector> loadData() {
		Vector<Vector> datas = new Vector<Vector>();
		Vector<Patient> ptis = pci.query();
		for (Patient patient : ptis) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(patient.getName());
			data.add(patient.getBirthday());
			data.add(patient.getGender());
			data.add(patient.getIdnum());
			data.add(patient.getPhone());
			data.add(patient.getEmergencyContact());
			data.add(patient.getEmergencyContactPhone());
			data.add("");
			datas.add(data);
			
		}
		return datas;
	}
	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
	private void btnEditActionPerformed(ActionEvent evt) {
		WorkerInfoEditFrame wief = new WorkerInfoEditFrame(currWorker);
//		System.out.println(currWorker.getAccount());
		wief.setLocationRelativeTo(null);
		wief.setVisible(true);
		wief.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void btnAddUserActionPerformed(ActionEvent evt) {
		PatientRegFrame prf = new PatientRegFrame(currWorker);
		prf.setLocationRelativeTo(null);
		prf.setVisible(true);
		prf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.dispose();
	}
	
	private void btnDeleteActionPerformed(ActionEvent evt) {
		List<Patient> selectedPatients = new Vector<Patient>();
		for (int i = 0; i < tblShowPatients.getRowCount(); i++) {
			if ((Boolean)tblShowPatients.getValueAt(i,0)) {
				selectedPatients.add(pci.getPatient((String)tblShowPatients.getValueAt(i,1)));
			}
		}
		for (Patient patient : selectedPatients) {
			pci.delete(patient);
		}
		datas = loadData();
		paintTable(datas);
	}
	
	private void btnSearchNameActionPerformed(ActionEvent evt) {
		String name = this.txtSearchName.getText();
		if (name.equals("")) {
			paintTable(datas);
		}else {
			Vector<Patient> ptis = pci.query();
			Vector<Vector> resultDatas = new Vector<Vector>();
			for (int i=0;i<ptis.size();i++) {
				if (ptis.get(i).getName().equals(name)) {
					resultDatas.add(datas.get(i));
				}
			}
			paintTable(resultDatas);
		}
	}
	
	private void btnSaveActionPerformed(ActionEvent evt) {
		Vector<Patient> ptis = pci.query();
		for (int i = 0; i < tblShowPatients.getRowCount(); i++) {
			Vector data = new Vector();
			Patient pti = pci.getPatient((String)tblShowPatients.getValueAt(i,1));
//			pti.setName((String) tblShowPatients.getValueAt(i, 1));
			pti.setBirthday((String) tblShowPatients.getValueAt(i, 2));
			pti.setGender((String) tblShowPatients.getValueAt(i, 3));
			pti.setIdnum((String) tblShowPatients.getValueAt(i, 4));
			pti.setPhone((String) tblShowPatients.getValueAt(i, 5));
			pti.setEmergencyContact((String) tblShowPatients.getValueAt(i, 6));
			pti.setEmergencyContactPhone((String) tblShowPatients.getValueAt(i, 8));
		}
		pci.save();
		datas = loadData();
		paintTable(datas);
	}
	
	private void btnModelListActionPerformed(ActionEvent evt) {
		QuesModelListFrame qmlf = new QuesModelListFrame();
		qmlf.setLocationRelativeTo(null);
		qmlf.setVisible(true);
		qmlf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}

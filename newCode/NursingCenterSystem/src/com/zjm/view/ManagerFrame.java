package com.zjm.view;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.zjm.model.Worker;
import com.zjm.service.impl.controller.ManagerControllerImpl;
import com.zjm.service.impl.controller.WorkerControllerImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
public class ManagerFrame extends javax.swing.JFrame {
	private JTextField txtSearchName;
	private JButton btnSearchName;
	private JButton btnBack;
	private JComboBox cboxJobTitle;
	private JTable tblShowWorkers;
	private JButton btnSave;
	private JButton btnAddWorker;
	private JButton btnDelete;
	private JScrollPane jspShow;

	/**
	* Auto-generated main method to display this JFrame
	*/
		

	private WorkerControllerImpl wci;
	private Vector<Vector> datas;
	public ManagerFrame() {
		super();
		this.wci = WorkerControllerImpl.getinstance();
		datas = loadData();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				txtSearchName = new JTextField();
				getContentPane().add(txtSearchName);
				txtSearchName.setBounds(12, 12, 125, 27);
			}
			{
				btnSearchName = new JButton();
				getContentPane().add(btnSearchName);
				btnSearchName.setText("\u59d3\u540d\u67e5\u8be2");
				btnSearchName.setBounds(156, 12, 104, 27);
				btnSearchName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSearchNameActionPerformed(evt);
					}
				});
			}
			{
				jspShow = new JScrollPane();
				getContentPane().add(jspShow);
				jspShow.setBounds(12, 115, 459, 196);
				jspShow.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				{
					paintTable(datas); 
				}
			}
			{
				btnDelete = new JButton();
				getContentPane().add(btnDelete);
				btnDelete.setText("\u5220\u9664");
				btnDelete.setBounds(12, 77, 76, 27);
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDeleteActionPerformed(evt);
					}
				});
			}
			{
				btnAddWorker = new JButton();
				getContentPane().add(btnAddWorker);
				btnAddWorker.setText("\u6dfb\u52a0\u5de5\u4f5c\u4eba\u5458");
				btnAddWorker.setBounds(347, 77, 112, 27);
				btnAddWorker.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnAddWorkerActionPerformed(evt);
					}
				});
			}
			{
				btnSave = new JButton();
				getContentPane().add(btnSave);
				btnSave.setText("\u4fdd\u5b58");
				btnSave.setBounds(88, 323, 68, 27);
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
				btnBack.setBounds(271, 323, 68, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				ComboBoxModel cboxJobTitleModel = 
					new DefaultComboBoxModel(
							new String[] { "ȫ��ְ��","ҽ��","��ʿ","����" });
				cboxJobTitle = new JComboBox();
				getContentPane().add(cboxJobTitle);
				cboxJobTitle.setModel(cboxJobTitleModel);
				cboxJobTitle.setBounds(12, 45, 125, 27);
				cboxJobTitle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cboxJobTitleActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(500, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/*
	 * ���Ʊ��Ĺ���
	 */
	private void paintTable(Vector<Vector> datas) {
		TableModel tblShowWorkersModel = 
			new DefaultTableModel(datas,wci.getColNames());
		tblShowWorkers = new JTable();
		jspShow.setViewportView(tblShowWorkers);
		tblShowWorkers.setModel(tblShowWorkersModel);
		TableColumn tc = tblShowWorkers.getColumnModel().getColumn(0);  
		tc.setCellEditor(tblShowWorkers.getDefaultEditor(Boolean.class));  
		tc.setCellRenderer(tblShowWorkers.getDefaultRenderer(Boolean.class));
	}

	/*
	 * ���ر������
	 */
	private Vector<Vector> loadData() {
		Vector<Vector> datas = new Vector<Vector>();
		Vector<Worker> wkrs = wci.query();
		for (Worker worker : wkrs) {
			Vector data = new Vector();
			data.add(new Boolean(false));
			data.add(worker.getAccount());
			data.add(worker.getRealname());
			data.add(worker.getBirthday());
			data.add(worker.getSpecialty());
			data.add(worker.getJobtitle());
			data.add(worker.getPhone());
			datas.add(data);
			
		}
		return datas;
	}
	
	private void btnAddWorkerActionPerformed(ActionEvent evt) {
		WorkerRegFrame wrf = new WorkerRegFrame();
		wrf.setLocationRelativeTo(null);
		wrf.setVisible(true);
		wrf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.dispose();
	}
	/*
	 * ɾ��������������񣬽���ѡ��ѡ�У�ֵΪtrue�������ݴӼ����в��ҳ��������뵽��ɾ����
	 * ������ɾ���ϣ������е�Ԫ��ͨ��������ɾ��
	 * ���¼������ݣ����Ʊ��
	 */
	private void btnDeleteActionPerformed(ActionEvent evt) {
		List<Worker> selectedWorkers = new Vector<Worker>();
		for (int i = 0; i < tblShowWorkers.getRowCount(); i++) {
			if ((Boolean)tblShowWorkers.getValueAt(i,0)) {
				selectedWorkers.add(wci.getWorker((String)tblShowWorkers.getValueAt(i, 1)));
			}
		}
		for (Worker worker : selectedWorkers) {
			wci.delete(worker);
		}
		datas = loadData();
		paintTable(datas);
	}
	/*
	 * �������ݣ��Ӽ����л�ȡ����ж�Ӧid�ĳ�Ա����������Ը�Ϊ����е�
	 * ͨ�����������浽�ļ�
	 * ���¼������ݣ����Ʊ��
	 */
	private void btnSaveActionPerformed(ActionEvent evt) {
		for (int i = 0; i < tblShowWorkers.getRowCount(); i++) {
			Worker wkr = wci.getWorker((String)tblShowWorkers.getValueAt(i, 1));
//			wkr.setAccount((String) tblShowWorkers.getValueAt(i, 1));
			wkr.setRealname((String) tblShowWorkers.getValueAt(i, 2));
			wkr.setBirthday((String) tblShowWorkers.getValueAt(i, 3));
			wkr.setSpecialty((String) tblShowWorkers.getValueAt(i, 4));
			wkr.setJobtitle((String) tblShowWorkers.getValueAt(i, 5));
			wkr.setPhone((String) tblShowWorkers.getValueAt(i, 6));
		}
		wci.save();
		datas = loadData();
		paintTable(datas);
	}
	/*
	 * ͨ��������ѯ
	 * ��ȡ�ı������������Ӽ����в�ѯ�����ҵ��򽫱�����ݼ����ж�Ӧ��һ��ȡ��
	 * �û�ȡ�����������»��Ʊ��
	 */
	private void btnSearchNameActionPerformed(ActionEvent evt) {
		String name = this.txtSearchName.getText();
		if (name.equals("")) {
			paintTable(datas);
		}else {
			Vector<Worker> wkrs = wci.query();
			Vector<Vector> resultDatas = new Vector<Vector>();
			for (int i=0;i<wkrs.size();i++) {
				if (wkrs.get(i).getRealname().equals(name)) {
					resultDatas.add(datas.get(i));
				}
			}
			paintTable(resultDatas);
		}
		
		
	}
	/*
	 * ��ȡcombox��ѡ�е���Ŀ
	 * ��ְ�����������ݵ�ְ�ƱȽϣ�����ͬ�����������
	 * �ý���������»��Ʊ��
	 */
	private void cboxJobTitleActionPerformed(ActionEvent evt) {
		String selected = this.cboxJobTitle.getSelectedItem().toString();
		Vector<Vector> resultDatas = new Vector<Vector>();
		if (selected.equals("ȫ��ְ��")) {
			paintTable(datas);
		}else {
			for (Vector data : datas) {
				if (data.get(5)!=null&&((String)data.get(5)).trim().equals(selected)) {
					resultDatas.add(data);
				}
			}
			paintTable(resultDatas);
		}
	}
	/*
	 * ���ز�����������ǰ����
	 */
	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

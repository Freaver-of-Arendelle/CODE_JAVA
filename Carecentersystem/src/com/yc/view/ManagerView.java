package com.yc.view;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yc.dao.impl.WorkerDAOImpl;
import com.yc.model.Worker;
import com.yc.service.control.WorkerServiceImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ManagerView extends javax.swing.JFrame {
	private JTextField jtxtFindName;
	private JComboBox jcbPosition;
	private JButton jbtBack;
	private JButton jbtFiN;
	private JButton jbtreserve;
	private JTable jTableWorkers;
	private JScrollPane jScrollPaneMan;
	private JButton jbtAddWorker;
	private JButton jbtDelete;
	private WorkerDAOImpl wdi;
	private WorkerServiceImpl wsi;
	private List<Worker> workers;
	private Vector<Vector<Object>> datas;
	/**
	 * Auto-generated main method to display this JFrame
	 */

	public ManagerView() {
		super();
		wdi = new WorkerDAOImpl();
		wsi = new WorkerServiceImpl();
		workers = wdi.query();
		datas = wsi.query();
		initGUI();

	}

	private void initGUI() {
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u7ba1\u7406\u4eba\u5458\u754c\u9762");
			{
				jtxtFindName = new JTextField();
				getContentPane().add(jtxtFindName);
				jtxtFindName.setBounds(27, 12, 90, 25);
			}
			{
				ComboBoxModel jcbPositionModel = new DefaultComboBoxModel(
						new String[] { "全部", "医生", "护士" });
				jcbPosition = new JComboBox();
				getContentPane().add(jcbPosition);
				jcbPosition.setModel(jcbPositionModel);
				jcbPosition.setBounds(26, 54, 134, 27);
				jcbPosition.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jcbPositionActionPerformed(evt);
					}
				});
			}
			{
				jbtDelete = new JButton();
				getContentPane().add(jbtDelete);
				jbtDelete.setText("\u5220\u9664");
				jbtDelete.setBounds(26, 96, 102, 30);
				jbtDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtDeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtAddWorker = new JButton();
				getContentPane().add(jbtAddWorker);
				jbtAddWorker.setText("\u6dfb\u52a0\u5de5\u4f5c\u4eba\u5458");
				jbtAddWorker.setBounds(458, 94, 145, 34);
				jbtAddWorker.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddWorkerActionPerformed(evt);
					}
				});
			}
			{
				jScrollPaneMan = new JScrollPane();
				getContentPane().add(jScrollPaneMan);
				jScrollPaneMan.setBounds(26, 146, 585, 171);
				{
					this.paintTable(wsi.query());
					jTableWorkers.setPreferredSize(new java.awt.Dimension(582,
							168));
				}
			}
			{
				jbtreserve = new JButton();
				getContentPane().add(jbtreserve);
				jbtreserve.setText("\u4fdd\u5b58");
				jbtreserve.setBounds(106, 328, 81, 27);
				jbtreserve.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtreserveActionPerformed(evt);
					}
				});
			}
			{
				jbtBack = new JButton();
				getContentPane().add(jbtBack);
				jbtBack.setText("\u8fd4\u56de");
				jbtBack.setBounds(380, 328, 82, 27);
				jbtBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtBackActionPerformed(evt);
					}
				});
			}
			{
				jbtFiN = new JButton();
				getContentPane().add(jbtFiN);
				jbtFiN.setText("\u59d3\u540d\u67e5\u8be2");
				jbtFiN.setBounds(129, 11, 103, 27);
				jbtFiN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtFiNActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(641, 413);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void paintTable(Vector<Vector<Object>> datas) {
		jTableWorkers = new JTable();
		jScrollPaneMan.setViewportView(jTableWorkers);
		TableModel tblShowWorkersModel = new DefaultTableModel(datas,
				wsi.getcolNames());
		jTableWorkers.setModel(tblShowWorkersModel);
		TableColumn tc = jTableWorkers.getColumnModel().getColumn(0);
		tc.setCellEditor(jTableWorkers.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(jTableWorkers.getDefaultRenderer(Boolean.class));
	}

	private void jbtAddWorkerActionPerformed(ActionEvent evt) {
		RegiserView rv = new RegiserView();
		rv.setVisible(true);
		rv.setLocationRelativeTo(null);
	}

	private void jbtDeleteActionPerformed(ActionEvent evt) {
		Vector<Worker> wkrs = wdi.query();
		List<Worker> selectedWorkers = new Vector<Worker>();
		for (int i = 0; i < jTableWorkers.getRowCount(); i++) {
			if ((Boolean) jTableWorkers.getValueAt(i, 0)) {
				selectedWorkers.add(wkrs.get(i));
			}
		}
		for (Worker worker : selectedWorkers) {
			wdi.delete(worker);
		}
		datas = wsi.query();
		paintTable(datas);
	}

	private void jbtFiNActionPerformed(ActionEvent evt) {
		String name = this.jtxtFindName.getText();
		//System.out.println(name);
		if (name.equals("")) {
			paintTable(wsi.query());
		} else {
			Vector<Worker> wkrs = wdi.query();
			Vector<Vector<Object>> resultDatas = new Vector<Vector<Object>>();
			Worker result = null;
			for (int i = 0; i < wkrs.size(); i++) {
				if (wkrs.get(i).getName().equals(name)) {
					resultDatas.add(datas.get(i));
				}
			}
			paintTable(resultDatas);
		}
	}

	private void jcbPositionActionPerformed(ActionEvent evt) {
		String position = this.jcbPosition.getSelectedItem().toString();
		Vector<Vector<Object>> resultDatas = new Vector<Vector<Object>>();
		if (position.equals("全部")) {
			paintTable(wsi.query());
		} else {
			for (Vector data : datas) {
				if (data.get(5) != null
						&& ((String) data.get(5)).trim().equals(position)) {
					resultDatas.add(data);
				}
			}
			paintTable(resultDatas);
		}

	}

	private void jbtreserveActionPerformed(ActionEvent evt) {
		Worker wkr;
		for (int i = 0; i < jTableWorkers.getRowCount(); i++) {
			wkr = workers.get(i);
			wkr.setUsername((String) jTableWorkers.getValueAt(i, 1));
			wkr.setName((String) jTableWorkers.getValueAt(i, 2));
			wkr.setBirthday((String) jTableWorkers.getValueAt(i, 3));
			wkr.setStrength((String) jTableWorkers.getValueAt(i, 4));
			wkr.setPosition((String) jTableWorkers.getValueAt(i, 5));
			wkr.setPhone((String) jTableWorkers.getValueAt(i, 6));
		}
		wdi.writeFile("c:\\abc\\users.txt");
		Vector<Worker> workers =wdi.query();
		for (Worker w : workers) {
			System.out.println(w.getAccount()+w.getPassword());
			
		}
		JOptionPane.showMessageDialog(null, "保存成功！");
	}

	private void jbtBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}
}
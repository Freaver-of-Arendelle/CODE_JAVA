package com.yc.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yc.tool.JTableEmbedJButton;

import com.yc.dao.impl.ModelDAOImpl;
import com.yc.dao.impl.PatientDAOImpl;
import com.yc.dao.impl.WorkerDAOImpl;
import com.yc.model.Model;
import com.yc.model.Patient;
import com.yc.model.Worker;
import com.yc.service.control.PatientServiceImpl;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class WorkerView extends javax.swing.JFrame {
	private JTextField jtxtFindName;
	private JButton jbtFix;
	private JButton jbtModel;
	private JScrollPane jScrollPane1;
	private JButton jbtReturn;
	private JButton jbtReserve;
	private JTable jtablePatient;
	private JButton jbtAdd;
	private JButton jbtDelete;
	private JButton jbtFindName;

	private PatientDAOImpl pdi = new PatientDAOImpl();
	private PatientServiceImpl psi = new PatientServiceImpl();
	private ModelDAOImpl mdi = new ModelDAOImpl();
	List<Patient> patients = pdi.query();
	private Vector<Vector<Object>> datas;
	private Worker worker;
	private WorkerDAOImpl wdi;
	private Vector<String> title;


	public WorkerView(Worker worker, WorkerDAOImpl wdi) {
		this.worker = worker;
		this.wdi = wdi;
		datas = psi.query();
		initGUI();
	}
//	public WorkerView(Worker worker) {
//		this.worker = worker;
//		datas = psi.query();
//		initGUI();
//	}

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public WorkerView() {
		super();
		initGUI();

	}

	private void initGUI() {
		
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u5de5\u4f5c\u4eba\u5458\u754c\u9762");
			{
				jtxtFindName = new JTextField();
				getContentPane().add(jtxtFindName);
				jtxtFindName.setBounds(27, 17, 82, 27);
			}
			{
				jbtFindName = new JButton();
				getContentPane().add(jbtFindName);
				jbtFindName.setText("\u59d3\u540d\u67e5\u8be2");
				jbtFindName.setBounds(126, 17, 100, 27);
				jbtFindName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtFindNameActionPerformed(evt);
					}
				});
			}
			{
				jbtDelete = new JButton();
				getContentPane().add(jbtDelete);
				jbtDelete.setText("\u5220\u9664");
				jbtDelete.setBounds(27, 88, 87, 34);
				jbtDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtDeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtFix = new JButton();
				getContentPane().add(jbtFix);
				jbtFix.setText("\u4fee\u6539\u4fe1\u606f");
				jbtFix.setBounds(484, 21, 117, 44);
				jbtFix.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtFixActionPerformed(evt);
					}
				});
			}
			{
				jbtModel = new JButton();
				getContentPane().add(jbtModel);
				jbtModel.setText("\u6a21\u677f\u5217\u8868");
				jbtModel.setBounds(330, 84, 109, 42);
				jbtModel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtModelActionPerformed(evt);
					}
				});
			}
			{
				jbtAdd = new JButton();
				getContentPane().add(jbtAdd);
				jbtAdd.setText("\u6dfb\u52a0\u75c5\u4eba");
				jbtAdd.setBounds(483, 84, 118, 42);
				jbtAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 137, 589, 122);
				jScrollPane1.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.LOWERED));
				{

					this.paintTable(psi.query());
					jtablePatient.getColumnModel().getColumn(8)
							.setCellEditor(new JTableEmbedJButton(psi.query(),worker));
					jtablePatient.getColumnModel().getColumn(8)
							.setCellRenderer(new JTableEmbedJButton(psi.query(),worker));
					jtablePatient.setPreferredSize(new java.awt.Dimension(585,
							117));
				}
			}
			{
				jbtReserve = new JButton();
				getContentPane().add(jbtReserve);
				jbtReserve.setText("\u4fdd\u5b58");
				jbtReserve.setBounds(114, 271, 70, 37);
				jbtReserve.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReserveActionPerformed(evt);
					}
				});
			}
			{
				jbtReturn = new JButton();
				getContentPane().add(jbtReturn);
				jbtReturn.setText("\u8fd4\u56de");
				jbtReturn.setBounds(339, 272, 81, 35);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(649, 395);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void paintTable(Vector<Vector<Object>> datas) {
		jtablePatient = new JTable();
		jScrollPane1.setViewportView(jtablePatient);
		TableModel tblShowWorkersModel = new DefaultTableModel(datas,
				psi.getcolNames());

		jtablePatient.setModel(tblShowWorkersModel);
		TableColumn tc = jtablePatient.getColumnModel().getColumn(0);
		tc.setCellEditor(jtablePatient.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(jtablePatient.getDefaultRenderer(Boolean.class));
	}

	public void update(Vector<Vector<Object>> vwt, Vector<Object> vwo,
			Patient pat) {
		vwo.add(new Boolean(false));
		vwo.add(pat.getName());
		vwo.add(pat.getBirthday());
		vwo.add(pat.getGender());
		vwo.add(pat.getIdno());
		vwo.add(pat.getPhone());
		vwo.add(pat.getEmercyant());
		vwo.add(pat.getEmercyphone());

		vwt.add(vwo);
	}

	private void jbtFindNameActionPerformed(ActionEvent evt) {
		String name = this.jtxtFindName.getText();
		List<Patient> patients = pdi.query();
		Vector<Vector<Object>> vwt = new Vector<Vector<Object>>();
		Vector<Object> vwo = new Vector<Object>();
		for (int i = 0; i < patients.size(); i++) {
			Patient p = patients.get(i);
			if (p.getName().equals(name)) {
				Patient pat = patients.get(i);
				this.update(vwt, vwo, pat);
			}
		}
		paintTable(vwt);
	}

	private void jbtDeleteActionPerformed(ActionEvent evt) {

		Vector<Patient> pats = pdi.query();
		List<Patient> selectedPatients = new Vector<Patient>();
		for (int i = 0; i < jtablePatient.getRowCount(); i++) {
			if ((Boolean) jtablePatient.getValueAt(i, 0)) {
				selectedPatients.add(pats.get(i));
			}
		}
		for (Patient patient : selectedPatients) {
			pdi.delete(patient);
		}
		datas = psi.query();
		paintTable(datas);
	}

	private void jbtAddActionPerformed(ActionEvent evt) {
		AddPatient ap = new AddPatient();
		ap.setVisible(true);
		ap.setLocationRelativeTo(null);
	}

	private void jbtReserveActionPerformed(ActionEvent evt) {
		Patient pat;
		for (int i = 0; i < jtablePatient.getRowCount(); i++) {
			pat = patients.get(i);
			pat.setName((String) jtablePatient.getValueAt(i, 1));
			pat.setBirthday((String) jtablePatient.getValueAt(i, 2));
			pat.setGender((String) jtablePatient.getValueAt(i, 3));
			pat.setIdno((String) jtablePatient.getValueAt(i, 4));
			pat.setPhone((String) jtablePatient.getValueAt(i, 5));
			pat.setEmercyant((String) jtablePatient.getValueAt(i, 6));
			pat.setEmercyphone((String) jtablePatient.getValueAt(i, 7));
		}
		pdi.writeFile("c:\\abc\\patients.txt");
		// psi.save();
		JOptionPane.showMessageDialog(null, "±£´æ³É¹¦£¡");
	}

	private void jbtFixActionPerformed(ActionEvent evt) {
		FixWorker fw = new FixWorker(worker,wdi);
		fw.setVisible(true);
		fw.setLocationRelativeTo(null);
	}

	private void jbtModelActionPerformed(ActionEvent evt) {
		ModelView mv = new ModelView();
		mv.setVisible(true);
		mv.setLocationRelativeTo(null);
	}

	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

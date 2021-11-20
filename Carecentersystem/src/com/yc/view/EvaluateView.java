package com.yc.view;

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

import com.yc.dao.impl.HistoryDAOImpl;
import com.yc.dao.impl.ModelDAOImpl;
import com.yc.model.History;
import com.yc.model.Model;
import com.yc.model.Patient;
import com.yc.model.Worker;
import com.yc.service.control.HistoryServiceImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class EvaluateView extends javax.swing.JFrame {
	private JButton jbtEvalute;
	private JScrollPane jScrollPane1;
	private JComboBox jcmbMC;
	private JTable jtbEstimator;
	private Vector<String> title;
	private Patient p;
	private Worker w;
	private Model m;
	private ModelDAOImpl mdi = new ModelDAOImpl();
	private Vector<Model> models = mdi.query();
	private HistoryDAOImpl hdi = new HistoryDAOImpl();
	private HistoryServiceImpl hsi = new HistoryServiceImpl();
	private Vector<Vector<Object>> datas;
	private History h = new History();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public EvaluateView(Patient p, Worker curWorker) {
		this.p = p;
		this.w = curWorker;
		this.title = this.gettitle();
		this.datas = hsi.query();
		// this.m=this.getModel(this.jcmbMC.getSelectedItem().toString());
		initGUI();
	}

	public EvaluateView() {
		super();
		initGUI();

	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u8bc4\u4f30\u754c\u9762");
			{
				jbtEvalute = new JButton();
				getContentPane().add(jbtEvalute);
				jbtEvalute.setText("\u5f00\u59cb\u8bc4\u4f30");
				jbtEvalute.setBounds(19, 38, 89, 37);
				jbtEvalute.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtEvaluteActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(19, 99, 565, 133);
				{
					paintTable(datas);
				}
			}
			{
				ComboBoxModel jcmbMCModel = new DefaultComboBoxModel(title);
				jcmbMC = new JComboBox();
				getContentPane().add(jcmbMC);
				jcmbMC.setModel(jcmbMCModel);
				jcmbMC.setBounds(422, 43, 130, 27);
			}
			pack();
			this.setSize(614, 359);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public Model getModel() {
		Model m = null;
		String name = this.jcmbMC.getSelectedItem().toString();
		//System.out.println(name);
		for (Model model : models) {
			if (model.getName().equals(name)) {
				m = model;
				break;
			}
		}
		return m;
	}

	public Vector<String> gettitle() {
		Model m;
		title = new Vector<String>();
		title.add("请选择模板");
		for (int i = 0; i < models.size(); i++) {
			m = models.get(i);
			title.add(m.getName());
		}
		return title;
	}

	public Vector<String> getcolNames() {
		Vector<String> cols = new Vector<String>();
		cols.add("姓名");
		cols.add("性别");
		cols.add("模板名称");
		cols.add("模板类型");
		cols.add("评估时间");
		cols.add("评估人");
		cols.add("建议");

		return cols;
	}

	private void paintTable(Vector<Vector<Object>> datas) {
		jtbEstimator = new JTable();
		jScrollPane1.setViewportView(jtbEstimator);
		TableModel tblShowWorkersModel = new DefaultTableModel(datas,
				this.getcolNames());
		jtbEstimator.setModel(tblShowWorkersModel);
	}

	private void jbtEvaluteActionPerformed(ActionEvent evt) {
		m=this.getModel();
		TestView tv = new TestView(m, p, w);
		tv.setVisible(true);
		tv.setLocationRelativeTo(null);
	}
}

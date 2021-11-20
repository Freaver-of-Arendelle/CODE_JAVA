package com.yc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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

import com.yc.dao.impl.ManagerDAOImpl;
import com.yc.dao.impl.ModelDAOImpl;
import com.yc.dao.impl.PatientDAOImpl;
import com.yc.dao.impl.QuestionDAOImpl;
import com.yc.dao.impl.WorkerDAOImpl;
import com.yc.model.Model;
import com.yc.model.Patient;
import com.yc.model.Question;
import com.yc.model.Worker;
import com.yc.service.control.ModelServiceImpl;
import com.yc.service.control.PatientServiceImpl;
import com.yc.service.control.QuestionServiceImpl;

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
public class ModelView extends javax.swing.JFrame {
	private JComboBox jcbType;
	private JButton jbtpreview;
	private JTable jTabModel;
	private JButton jbtReturn;
	private JButton jbtReserve;
	private JScrollPane jScrollPane1;
	private JButton jbtAdd;
	private JButton jbrdelete;
	private ModelDAOImpl mdi = new ModelDAOImpl();
	private ModelServiceImpl msi = new ModelServiceImpl();
	private QuestionServiceImpl qsi = new QuestionServiceImpl();
	private QuestionDAOImpl qdi = new QuestionDAOImpl();
	private List<Model> models = mdi.query();
	private List<Question> questions = qdi.query();
	private Vector<Vector<Object>> datas;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public ModelView() {
		super();
		datas = msi.query();
		initGUI();
	}

	private void initGUI() {

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u95ee\u5377\u5217\u8868");
			{
				ComboBoxModel jlistModel = new DefaultComboBoxModel(
						new String[] { "全部", "A", "B", "C" });
				jcbType = new JComboBox();
				getContentPane().add(jcbType);
				jcbType.setModel(jlistModel);
				jcbType.setBounds(25, 21, 131, 27);
				jcbType.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jcbTypeActionPerformed(evt);
					}
				});
			}
			{
				jbtpreview = new JButton();
				getContentPane().add(jbtpreview);
				jbtpreview.setText("\u9884\u89c8");
				jbtpreview.setBounds(20, 74, 77, 27);
				jbtpreview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtpreviewActionPerformed(evt);
					}
				});
			}
			{
				jbrdelete = new JButton();
				getContentPane().add(jbrdelete);
				jbrdelete.setText("\u5220\u9664");
				jbrdelete.setBounds(121, 74, 83, 27);
				jbrdelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbrdeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtAdd = new JButton();
				getContentPane().add(jbtAdd);
				jbtAdd.setText("\u65b0\u5efa\u6a21\u677f");
				jbtAdd.setBounds(431, 68, 123, 39);
				jbtAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(32, 129, 513, 138);
				{
					this.paintTable(msi.query());
				}
			}
			{
				jbtReserve = new JButton();
				getContentPane().add(jbtReserve);
				jbtReserve.setText("\u4fdd\u5b58");
				jbtReserve.setBounds(97, 283, 88, 33);
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
				jbtReturn.setBounds(340, 284, 77, 31);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(608, 378);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void paintTable(Vector<Vector<Object>> datas) {
		jTabModel = new JTable();
		jScrollPane1.setViewportView(jTabModel);
		TableModel tblShowWorkersModel = new DefaultTableModel(datas,
				msi.getcolNames());
		jTabModel.setModel(tblShowWorkersModel);
		TableColumn tc = jTabModel.getColumnModel().getColumn(0);
		tc.setCellEditor(jTabModel.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(jTabModel.getDefaultRenderer(Boolean.class));
	}

	private Boolean compare(Question q, Vector<Question> questions) {
		Boolean flag = true;
		for (Question question : questions) {
			if (q.getQuestion().equals(question.getQuestion())) {
				flag = false;
			}
		}
		return flag;
	}

	private void jbtReserveActionPerformed(ActionEvent evt) {
		Model m = null;
		for (int i = 0; i < jTabModel.getRowCount(); i++) {
			m = models.get(i);
			m.setName((String) jTabModel.getValueAt(i, 2));
			m.setType((String) jTabModel.getValueAt(i, 3));
		}
		for (int i = 0; i < models.size(); i++) {
			m = models.get(i);
			for (int j = 0; j < m.getQuestions().size(); j++) {
				if (this.compare(m.getQuestions().get(j), qdi.query())) {
					m.getQuestions().remove(j);
				}
			}
		}
		 mdi.writeFile("c:\\abc\\models.txt");
		 JOptionPane.showMessageDialog(null, "保存成功！");
	}

	private void jbtAddActionPerformed(ActionEvent evt) {
		AddModel am = new AddModel();
		am.setVisible(true);
		am.setLocationRelativeTo(null);
	}

	private void jcbTypeActionPerformed(ActionEvent evt) {
		String type = this.jcbType.getSelectedItem().toString();
		Vector<Vector<Object>> resultDatas = new Vector<Vector<Object>>();
		if (type.equals("全部")) {
			paintTable(msi.query());
		} else {
			for (Vector data : datas) {
				if (data.get(3) != null
						&& ((String) data.get(3)).trim().equals(type)) {
					resultDatas.add(data);
				}
			}
			paintTable(resultDatas);
		}
	}

	private void jbrdeleteActionPerformed(ActionEvent evt) {
		List<Model> selectedModels = new Vector<Model>();
		for (int i = 0; i < jTabModel.getRowCount(); i++) {
			if ((Boolean) jTabModel.getValueAt(i, 0)) {
				selectedModels.add(models.get(i));
			}
		}
		for (Model model : selectedModels) {
			mdi.delete(model);
		}
		datas = msi.query();
		paintTable(datas);
	}

	private void jbtpreviewActionPerformed(ActionEvent evt) {
		for (int i = 0; i < jTabModel.getRowCount(); i++) {
			if ((Boolean) jTabModel.getValueAt(i, 0)) {
				Preview pv = new Preview(models.get(i));
				pv.setLocationRelativeTo(null);
				pv.setVisible(true);
			}
		}
		// Vector<Model> models = mdi.query();
		// Model m=new Model();
		// for (int i = 0; i < jTabModel.getRowCount(); i++) {
		// if ((Boolean) jTabModel.getValueAt(i, 0)) {
		// m=models.get(i);
		// }
		// }
		// Preview pv =new Preview(m);
		// pv.setVisible(true);
		// pv.setLocationRelativeTo(null);
	}

	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

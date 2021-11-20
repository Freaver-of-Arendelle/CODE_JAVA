package com.yc.view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yc.dao.impl.ModelDAOImpl;
import com.yc.model.Model;
import com.yc.model.Question;
import com.yc.model.Worker;
import com.yc.service.control.ModelServiceImpl;
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
public class Preview extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jbtdelete;
	private JLabel jlabModel;
	private JButton jbtReturn;
	private JButton jbtAdd;
	private JTable jtbModel;
	private Model model;
	private QuestionServiceImpl qsi = new QuestionServiceImpl();
	private ModelDAOImpl mdi = new ModelDAOImpl();
	private ModelServiceImpl msi = new ModelServiceImpl();
	private Vector<Vector<Object>> datas;

	/**
	 * Auto-generated main method to display this JFrame
	 */

	public Preview() {
		super();
		initGUI();
	}

	public Preview(Model model) {
		super();
		this.model = model;
		this.datas=getTable();
		initGUI();
	}

	private void initGUI() {

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u95ee\u5377\u9884\u89c8\u754c\u9762");
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 68, 457, 140);
				paintTable(datas);

			}
			{
				jbtAdd = new JButton();
				getContentPane().add(jbtAdd);
				jbtAdd.setText("\u6dfb\u52a0");
				jbtAdd.setBounds(396, 33, 75, 32);
				jbtAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddActionPerformed(evt);
					}
				});
			}
			{
				jbtdelete = new JButton();
				getContentPane().add(jbtdelete);
				jbtdelete.setText("\u5220\u9664");
				jbtdelete.setBounds(85, 220, 77, 33);
				jbtdelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtdeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtReturn = new JButton();
				getContentPane().add(jbtReturn);
				jbtReturn.setText("\u8fd4\u56de");
				jbtReturn.setBounds(300, 221, 73, 31);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			{
				jlabModel = new JLabel();
				getContentPane().add(jlabModel);
				jlabModel.setText(model.getName());
				jlabModel.setBounds(52, 33, 39, 17);
			}
			pack();
			this.setSize(514, 312);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public Vector<Vector<Object>> getTable() {
		Vector<Question> questions = (Vector<Question>) model.getQuestions();
		Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
		for (Question question : questions) {
			Vector<Object> data = new Vector<Object>();
			data.add(new Boolean(false));
			data.add(question.getId());
			data.add(question.getQuestion());
			data.add(question.getType());
			datas.add(data);
		}
		return datas;
	}

	private void paintTable(Vector<Vector<Object>> datas) {

		TableModel tblShowWorkersModel = new DefaultTableModel(datas,
				qsi.getcolNames());
		jtbModel = new JTable();
		jScrollPane1.setViewportView(jtbModel);
		jtbModel.setModel(tblShowWorkersModel);
		TableColumn tc = jtbModel.getColumnModel().getColumn(0);
		tc.setCellEditor(jtbModel.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(jtbModel.getDefaultRenderer(Boolean.class));
	}

	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	private void jbtdeleteActionPerformed(ActionEvent evt) {
		Vector<Question> questions = model.getQuestions();
		List<Question> selectedQuestions = new Vector<Question>();
		for (int i = 0; i < jtbModel.getRowCount(); i++) {
			if ((Boolean) jtbModel.getValueAt(i, 0)) {
				selectedQuestions.add(questions.get(i));
			}
		}
		for (Question question : selectedQuestions) {
			model.getQuestions().remove(question);
			
		}
		mdi.writeFile("c:\\abc\\models.txt");
		datas = getTable();
		paintTable(datas);
	}

	private void jbtAddActionPerformed(ActionEvent evt) {
		QuestionView qv = new QuestionView(model);
		qv.setVisible(true);
		qv.setLocationRelativeTo(null);
		this.dispose();
	}

}

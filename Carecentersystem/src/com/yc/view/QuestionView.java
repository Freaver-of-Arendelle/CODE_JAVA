package com.yc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import com.yc.dao.impl.ModelDAOImpl;
import com.yc.dao.impl.QuestionDAOImpl;
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
public class QuestionView extends javax.swing.JFrame {
	private JButton jbtDelete;
	private JButton jbtdetalis;
	private JTable JtabQuestion;
	private JButton jbtReturn;
	private JButton jbtAddinto;
	private JScrollPane jspQuestion;
	private JButton jbtAdd;
	private QuestionServiceImpl qsi = new QuestionServiceImpl();
	private QuestionDAOImpl qdi = new QuestionDAOImpl();
	private ModelDAOImpl mdi = new ModelDAOImpl();
	private ModelServiceImpl msi = new ModelServiceImpl();
	private Model m;
	private Vector<Vector<Object>> datas = new Vector<Vector<Object>>();

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public QuestionView(Model model) {
		super();
		this.m = model;
		datas = qsi.query();
		initGUI();

	}

	public QuestionView() {
		super();
		// datas = qsi.query();
		initGUI();
	}

	private void initGUI() {

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u95ee\u9898\u5e93");
			{
				jbtDelete = new JButton();
				getContentPane().add(jbtDelete);
				jbtDelete.setText("\u5220\u9664");
				jbtDelete.setBounds(35, 65, 82, 40);
				jbtDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtDeleteActionPerformed(evt);
					}
				});
			}
			{
				jbtdetalis = new JButton();
				getContentPane().add(jbtdetalis);
				jbtdetalis.setText("\u8be6\u60c5");
				jbtdetalis.setBounds(355, 68, 75, 37);
				jbtdetalis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtdetalisActionPerformed(evt);
					}
				});
			}
			{
				jbtAdd = new JButton();
				getContentPane().add(jbtAdd);
				jbtAdd.setText("\u65b0\u589e");
				jbtAdd.setBounds(467, 71, 67, 34);
				jbtAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddActionPerformed(evt);
					}
				});
			}
			{
				jspQuestion = new JScrollPane();
				getContentPane().add(jspQuestion);
				jspQuestion.setBounds(35, 159, 514, 196);
				{
					this.paintTable(qsi.query());
				}
			}
			{
				jbtAddinto = new JButton();
				getContentPane().add(jbtAddinto);
				jbtAddinto.setText("\u6dfb\u52a0");
				jbtAddinto.setBounds(85, 380, 79, 35);
				jbtAddinto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtAddintoActionPerformed(evt);
					}
				});
			}
			{
				jbtReturn = new JButton();
				getContentPane().add(jbtReturn);
				jbtReturn.setText("\u8fd4\u56de");
				jbtReturn.setBounds(383, 379, 76, 34);
				jbtReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jbtReturnActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(604, 476);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void paintTable(Vector<Vector<Object>> datas) {
		JtabQuestion = new JTable();
		jspQuestion.setViewportView(JtabQuestion);
		TableModel tblShowWorkersModel = new DefaultTableModel(datas,
				qsi.getcolNames());

		JtabQuestion.setModel(tblShowWorkersModel);
		TableColumn tc = JtabQuestion.getColumnModel().getColumn(0);
		tc.setCellEditor(JtabQuestion.getDefaultEditor(Boolean.class));
		tc.setCellRenderer(JtabQuestion.getDefaultRenderer(Boolean.class));
	}

	private void jbtDeleteActionPerformed(ActionEvent evt) {
		Vector<Question> questions = qdi.query();
		List<Question> selectedQuestions = new Vector<Question>();
		for (int i = 0; i < JtabQuestion.getRowCount(); i++) {
			if ((Boolean) JtabQuestion.getValueAt(i, 0)) {
				selectedQuestions.add(questions.get(i));
			}
		}
		for (Question question : selectedQuestions) {
			qdi.delete(question);

		}
		datas = qsi.query();
		paintTable(datas);
	}

	private void jbtAddintoActionPerformed(ActionEvent evt) {
		Vector<Question> questions = qdi.query();
		List<Question> selectedQuestions = new Vector<Question>();
		for (int i = 0; i < JtabQuestion.getRowCount(); i++) {
			if ((Boolean) JtabQuestion.getValueAt(i, 0)) {
				selectedQuestions.add(questions.get(i));
			}
		}
		for (Question question : selectedQuestions) {
			m.getQuestions().add(question);
		}
		mdi.writeFile("c:\\abc\\models.txt");
		Preview pv = new Preview(m);
		pv.setLocationRelativeTo(null);
		pv.setVisible(true);
		this.dispose();
	}

	private void jbtdetalisActionPerformed(ActionEvent evt) {
		Question selectedQuestion = null;
		for (int i = 0; i < JtabQuestion.getRowCount(); i++) {
			if ((Boolean) JtabQuestion.getValueAt(i, 0)) {
				selectedQuestion = m.getQuestions().get(i);
			}
		}
		DetailView dv = new DetailView(selectedQuestion);
		dv.setLocationRelativeTo(null);
		dv.setVisible(true);
	}

	private void jbtAddActionPerformed(ActionEvent evt) {
		AddQuestion ad = new AddQuestion();
		ad.setVisible(true);
		ad.setLocationRelativeTo(null);
	}

	private void jbtReturnActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

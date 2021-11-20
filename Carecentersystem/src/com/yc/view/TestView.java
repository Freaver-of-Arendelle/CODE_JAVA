package com.yc.view;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.yc.dao.impl.HistoryDAOImpl;
import com.yc.model.History;
import com.yc.model.Model;
import com.yc.model.Patient;
import com.yc.model.Question;
import com.yc.model.Worker;
import com.yc.service.control.HistoryServiceImpl;

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
public class TestView extends javax.swing.JFrame {
	private JScrollPane jspShow;
	private JButton btnSubmit;
	private JButton btnBack;
	private JPanel jp;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	private HistoryDAOImpl hdi = new HistoryDAOImpl();
	private HistoryServiceImpl hsi = new HistoryServiceImpl();
	private Model m;
	private Patient p;
	private Worker w;

	public TestView(Model m, Patient p, Worker currWorker) {
		super();
		this.m = m;
		this.p = p;
		this.w = currWorker;
		bgs = new ButtonGroup[m.getQuestions().size()];
		initGUI();
	}

	private ButtonGroup[] bgs;

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u8c03\u67e5\u95ee\u5377");
			{
				jspShow = new JScrollPane();
				getContentPane().add(jspShow);
				jspShow.setBounds(12, 25, 358, 267);
				{
					jp = new JPanel();
					jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
					jspShow.setViewportView(jp);
				}
			}
			{
				btnSubmit = new JButton();
				getContentPane().add(btnSubmit);
				btnSubmit.setText("\u63d0\u4ea4");
				btnSubmit.setBounds(67, 318, 71, 27);
				btnSubmit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnSubmitActionPerformed(evt);
					}
				});
			}
			{
				btnBack = new JButton();
				getContentPane().add(btnBack);
				btnBack.setText("\u8fd4\u56de");
				btnBack.setBounds(210, 318, 71, 27);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnBackActionPerformed(evt);
					}
				});
			}
			{
				JLabel[] js = new JLabel[m.getQuestions().size()];

				Question tempQues = null;
				for (int i = 0; i < bgs.length; i++) {

					tempQues = m.getQuestions().get(i);
					bgs[i] = new ButtonGroup();
					js[i] = new JLabel(tempQues.getQuestion());
					js[i].setBounds(0, 30 * (i + 1), 150, 50);
					jp.add(js[i]);

					JRadioButton[] jrbs = new JRadioButton[3];
					jrbs[0] = new JRadioButton();// 实例化第一个单选按钮
					jrbs[0].setBounds(0, 60 * (i + 1), 100, 50);// 设置位置及大小
					jrbs[0].setText(tempQues.getOptionA());
					jrbs[0].setActionCommand("A" + i);
					// 将单选按钮加入到第一组中
					bgs[i].add(jrbs[0]);
					// 将单选按钮加入到窗口中
					jp.add(jrbs[0]);

					jrbs[1] = new JRadioButton();
					jrbs[1].setBounds(0, 90 * (i + 1), 100, 50);
					jrbs[1].setText(tempQues.getOptionB());
					jrbs[1].setActionCommand("B" + i);
					bgs[i].add(jrbs[1]);
					jp.add(jrbs[1]);

					jrbs[2] = new JRadioButton();
					jrbs[2].setBounds(0, 120 * (i + 1), 100, 50);
					jrbs[2].setText(tempQues.getOptionC());
					jrbs[2].setActionCommand("C" + i);
					bgs[i].add(jrbs[2]);
					jp.add(jrbs[2]);
				}
			}
			pack();
			this.setSize(400, 415);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void btnSubmitActionPerformed(ActionEvent evt) {
		int score = 0;
		String advice = null;
		char op;
		for (int i = 0; i < bgs.length; i++) {
			op = bgs[i].getSelection().getActionCommand().toCharArray()[0];
			if (op == 'A') {
				score += 5;
			} else if (op == 'B') {
				score += 3;
			} else if (op == 'C') {
				score += 1;
			}

		}
		if (score >= 10) {
			advice = "优秀";
		} else if (score > 5 && score < 10) {
			advice = "良好";
		} else if (score <= 5) {
			advice = "重点关照！";
		}

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		History data = new History(p.getName(), p.getGender(), m.getName(),
				m.getType(), ft.format(dNow), w.getName(), advice);
		hdi.register(data);
		hdi.writeFile("c:\\abc\\history.txt");
		JOptionPane.showMessageDialog(null, "交卷成功!");
	}

	private void btnBackActionPerformed(ActionEvent evt) {
		this.dispose();
	}

}

package com.yc.tool;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.yc.dao.impl.ModelDAOImpl;
import com.yc.model.Model;
import com.yc.model.Patient;
import com.yc.model.Worker;
import com.yc.service.control.PatientServiceImpl;
import com.yc.view.EvaluateView;

public class JTableEmbedJButton extends AbstractCellEditor implements
		TableCellEditor, TableCellRenderer {
	private PatientServiceImpl psi = new PatientServiceImpl();
	private MyButton jb;
	private Worker worker;
	private Vector<Vector<Object>> datas;

	public JTableEmbedJButton(final Vector<Vector<Object>> datas,
			final Worker currWorker) {
		this.datas=datas;
		this.worker = currWorker;
		jb = new MyButton("ÆÀ¹À");
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("a");
//				System.out.println(jb.getRow());
				final String name = (String) datas.get(jb.getRow()).get(1);
				Patient p = psi.getPatient(name);
				EvaluateView ev = new EvaluateView(p,worker);
				ev.setVisible(true);
				ev.setLocationRelativeTo(null);

			}
		});
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		// TODO Auto-generated method stub
		return jb;
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1,
			boolean arg2, int arg3, int arg4) {
		jb.setRow(arg3);
		jb.setColumn(arg4);
		return jb;
	}

}

package com.zjm.dao.table;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.zjm.model.Patient;
import com.zjm.model.Worker;
import com.zjm.service.impl.controller.PatientControllerImpl;
import com.zjm.view.EvaluateFrame;

public class JTableEmbedJbutton extends AbstractCellEditor implements
		TableCellEditor, TableCellRenderer {

	MyButton jb;
	PatientControllerImpl pci = PatientControllerImpl.getinstance();
	
	public JTableEmbedJbutton(String title,final Vector<Vector> datas, final Worker currWorker) {
		jb = new MyButton(title);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final String name = (String) datas.get(jb.getRow()).get(1);
				Patient p = pci.getPatient(name);
				EvaluateFrame ef = new EvaluateFrame(p,currWorker);
				ef.setLocationRelativeTo(null);
				ef.setVisible(true);
			}
		});
	}

	public JTableEmbedJbutton(String title) {
		jb = new MyButton(title);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EvaluateFrame ef = new EvaluateFrame();
				ef.setLocationRelativeTo(null);
				ef.setVisible(true);
			}
		});
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return jb;
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
		//加入设置按钮所在行列的语句
		jb.setRow(arg3);
		jb.setColumn(arg4);
		return jb;
	}

}

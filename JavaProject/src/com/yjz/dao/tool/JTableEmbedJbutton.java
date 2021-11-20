package com.yjz.dao.tool;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.yjz.model.Admin;
import com.yjz.model.Model;
import com.yjz.model.Patient;
import com.yjz.service.impl.control.ModelControllerImpl;
import com.yjz.service.impl.control.PatientControllerImpl;
import com.yjz.view.EvaluateView;
import com.yjz.view.LoginView;

public class JTableEmbedJbutton extends AbstractCellEditor implements
		TableCellEditor, TableCellRenderer {

	MyButton jb;
	//评估按钮的设置
	public JTableEmbedJbutton(String title,final Admin admin,final ModelControllerImpl mci,final PatientControllerImpl pci) {
		jb = new MyButton(title);
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			 Patient patient = pci.query().get(jb.getRow());
				//System.out.println(patient.getName());//不清楚
				JOptionPane.showMessageDialog(null, jb.getText());
				EvaluateView av = new EvaluateView(mci,admin,patient);
				av.setLocationRelativeTo(null);
				av.setVisible(true);
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
		// TODO Auto-generated method stub
		jb.setRow(arg3);
		jb.setColumn(arg4);
		//通过获取行列得到病患信息
		return jb;
	}
	

}

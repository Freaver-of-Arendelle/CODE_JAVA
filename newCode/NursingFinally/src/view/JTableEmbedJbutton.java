package view;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

@Deprecated
public class JTableEmbedJbutton extends AbstractCellEditor implements
		TableCellEditor, TableCellRenderer {

	JButton jb;
	
	public JTableEmbedJbutton(String title) {
		jb = new JButton(title);
		jb.addActionListener(arg0 -> new EstimatorUI().setVisible(true));
	}

	@Override
	public Object getCellEditorValue() {
		return jb;
	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		return jb;
	}

	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1,
			boolean arg2, int arg3, int arg4) {
		return jb;
	}

}

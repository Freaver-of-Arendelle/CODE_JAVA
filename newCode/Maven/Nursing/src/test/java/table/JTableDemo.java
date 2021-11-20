package table;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Freaver
 * @Time 07/15/2021 15:26
 * @Description
 */
public class JTableDemo {
    private class ButtonRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            button.setText("before");
            return button;
        }

        private class ButtonEditor extends DefaultCellEditor {
            private static final long serialVersionUID = -6546334664166791132L;

            public ButtonEditor() {
                super(new JTextField());
                this.setClickCountToStart(1);
            }

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton button = (JButton)value;
                button.setText("after");
                button.addActionListener(new AbstractAction() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("edit!!!!"); //$NON-NLS-1$
                    }
                });
                return button;
            }
        }
    }

}



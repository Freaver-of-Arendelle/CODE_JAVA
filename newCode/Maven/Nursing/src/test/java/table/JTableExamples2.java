package table;

import org.junit.Test;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JTableExamples2 {
    // frame
    JFrame f;
    // Table
    JTable j;

    // Constructor
    JTableExamples2() {
        // Frame initiallization
        f = new JFrame();

        // Frame Title
        f.setTitle("JTable Example"); //$NON-NLS-1$

        // Initializing the JTable
        j = new JTable(new JTablePatient());
        j.addColumn(new TableColumn(0));
        j.addColumn(new TableColumn(1));
        j.addColumn(new TableColumn(2));
        j.addColumn(new TableColumn(3));
        j.addColumn(new TableColumn(4));
        j.addColumn(new TableColumn(5));
        j.addColumn(new TableColumn(6));
        j.addColumn(new TableColumn(7));
        j.addColumn(new TableColumn(8, 200, new ButtonRenderer(), new ButtonEditor()));

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }

    // Driver method
    @Test
    void test() {
        new JTableExamples2();
    }

    private class ButtonRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            button.setText("before"); //$NON-NLS-1$
            return button;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        private static final long serialVersionUID = -6546334664166791132L;

        public ButtonEditor() {
            super(new JTextField());
            this.setClickCountToStart(1);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JButton button = (JButton) value;
            button.setText("after"); //$NON-NLS-1$
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


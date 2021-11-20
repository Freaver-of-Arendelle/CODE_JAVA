package swingDemo.model;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Freaver
 * @date 07/02/2021 10:38
 */
public class LIstModelDemo {

    JFrame mainWin = new JFrame("test ListModel");

    JList<BigDecimal> numScopeList = new JList<>(new NumberListModel(1, 21, 2));

    JComboBox<BigDecimal> numScopeSelector = new JComboBox<>(new NumberComboBoxModel(0.1, 1.2, 0.1));

    JTextField showVal = new JTextField(10);

    public void init() {
        numScopeList.setVisibleRowCount(4);

        numScopeList.setSelectionInterval(2, 4);

        numScopeList.setFixedCellHeight(30);
        numScopeList.setFixedCellWidth(30);

        numScopeList.addListSelectionListener(e -> {
            List<BigDecimal> selectedValuesList = numScopeList.getSelectedValuesList();

            showVal.setText("");
            for (BigDecimal bigDecimal : selectedValuesList) {

                showVal.setText(showVal.getText() + bigDecimal.toString() + ", ");
            }
        });

        numScopeSelector.addItemListener(e -> {
            Object value = numScopeSelector.getSelectedItem();
            showVal.setText(value.toString());
        });

        Box box = Box.createHorizontalBox();
        box.add(new JScrollPane(numScopeList));

        JPanel p = new JPanel();
        p.add(numScopeSelector);
        box.add(p);

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("The value your choose is: "));
        bottom.add(showVal);

        mainWin.add(box);
        mainWin.add(bottom, BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new LIstModelDemo().init();
    }
}

package swingDemo.model;

import javax.swing.*;
import java.awt.*;

/**
 * @author Freaver
 * @date 07/02/2021 11:42
 */
public class DefaultListModelDemo {
    JFrame mainWin = new JFrame("test DefaultListModel");

    JList<String> bookList;

    DefaultListModel<String> bookModel = new DefaultListModel<>();

    JTextField bookName = new JTextField(20);

    JButton removeBtn = new JButton("delete selected book");
    JButton addBtn = new JButton("add selected book");

    public void init() {
        bookModel.addElement("java自学宝典");
        bookModel.addElement("轻量级javaEE企业应用实战");
        bookModel.addElement("Android基础教程");
        bookModel.addElement("jQuery实战教程");
        bookModel.addElement("SpringBoot企业级开发");

        bookList = new JList<>(bookModel);

        bookList.setVisibleRowCount(4);

        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addBtn.addActionListener(e -> {
            if (!bookName.getText().trim().equals("")) {
                bookModel.addElement(bookName.getText());
            }
        });

        removeBtn.addActionListener(e -> {
            int selectedIndex = bookList.getSelectedIndex();
            if (selectedIndex >= 0) {
                bookModel.remove(selectedIndex);
            }
        });

        JPanel p = new JPanel();
        p.add(bookName);
        p.add(addBtn);
        p.add(removeBtn);

        mainWin.add(new JScrollPane(bookList));
        mainWin.add(p, BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultListModelDemo().init();
    }
}

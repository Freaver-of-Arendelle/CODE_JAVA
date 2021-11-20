package swingDemo.componentDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Freaver
 * @date 07/01/2021 14:48
 */
public class InputDialogDemo {

    JFrame jf = new JFrame("test input dialog");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("pop input dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object result = JOptionPane.showInputDialog(jf, "", "input dialog", JOptionPane.DEFAULT_OPTION, null, new String[] {"😅", "😘", "😋", "😥"}, "😘");
            if (result != null) {
                jta.append(result.toString());
            }
        }
    });

    public void init() {
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new InputDialogDemo().init();
    }
}

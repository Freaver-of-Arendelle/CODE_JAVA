package swingDemo.componentDemo;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Freaver
 * @date 07/01/2021 14:41
 */
public class ConfirmDialogDemo {
    JFrame jf = new JFrame("test confirm dialog");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("pop confirm dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(jf, jta.getText(),
                    "confirm dialog", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {
                jta.append("\nUser click confirm button");
            }

            if (result == JOptionPane.NO_OPTION) {
                jta.append("\nUser click cancel button");
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
        new ConfirmDialogDemo().init();
    }
}

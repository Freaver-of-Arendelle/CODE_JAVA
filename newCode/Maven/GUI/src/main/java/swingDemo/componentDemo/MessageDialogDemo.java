package swingDemo.componentDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Freaver
 * @date 07/01/2021 14:32
 */
public class MessageDialogDemo {
    JFrame jf = new JFrame("test message dialog");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("pop message dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JOptionPane.showMessageDialog(jf, jta.getText(), "message dialog", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(jf, jta.getText(), "message dialog", JOptionPane.INFORMATION_MESSAGE);
//            JOptionPane.showMessageDialog(jf, jta.getText(), "message dialog", JOptionPane.WARNING_MESSAGE);
//            JOptionPane.showMessageDialog(jf, jta.getText(), "message dialog", JOptionPane.QUESTION_MESSAGE);
//            JOptionPane.showMessageDialog(jf, jta.getText(), "message dialog", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(jf, jta.getText(), "message dialog", JOptionPane.ERROR_MESSAGE, new ImageIcon("img/component/female.png"));
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
        new MessageDialogDemo().init();
    }
}

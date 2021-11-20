package swingDemo.componentDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Freaver
 * @date 07/01/2021 14:59
 */
public class OptionDialogDemo {
    JFrame jf = new JFrame("test option dialog");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("pop option dialog") {
        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showOptionDialog(jf, "Please choose the emoji", "option dialog",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, new String[]{"😘", "😅", "😋", "😍"}, null);

            switch (result) {
                case 0:
                    jta.setText("User choose 😘");
                    break;
                case 2:
                    jta.setText("User choose 😅");
                    break;
                case 3:
                    jta.setText("User choose 😋");
                    break;
                case 4:
                    jta.setText("User choose 😍");
                    break;
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
        new OptionDialogDemo().init();
    }
}

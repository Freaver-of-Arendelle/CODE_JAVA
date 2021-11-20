package swingDemo.componentDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Freaver
 * @date 07/01/2021 13:38
 */
public class JColorChooserDemo {

    JFrame jFrame = new JFrame("test color chooser");
    JTextArea jta = new JTextArea("I love China", 6, 30);

    JButton button = new JButton(new AbstractAction("Change the background") {
        @Override
        public void actionPerformed(ActionEvent e) {
            JColorChooser.showDialog(jFrame, "Color Chooser", Color.WHITE);
            jta.setBackground(Color.BLUE);
        }
    });

    public void init() {
        jFrame.add(jta);

        jFrame.add(button, BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new JColorChooserDemo().init();
    }
}

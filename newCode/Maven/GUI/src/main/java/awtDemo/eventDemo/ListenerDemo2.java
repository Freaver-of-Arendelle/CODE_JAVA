package awtDemo.eventDemo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Freaver
 * @date 06/29/2021 19:55
 */
public class ListenerDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame();


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setBounds(200, 200, 500, 300);
        frame.setVisible(true);
    }
}

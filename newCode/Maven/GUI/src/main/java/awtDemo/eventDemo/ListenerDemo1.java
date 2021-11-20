package awtDemo.eventDemo;

import java.awt.*;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

/**
 * @author Freaver
 * @date 06/29/2021 17:46
 */
public class ListenerDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("Here test Listener");

        TextField tf = new TextField(30);

        tf.addTextListener(e -> System.out.println("Current context: " + tf.getText()));


        frame.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println(child);
            }
        });

        frame.add(tf);

        frame.pack();
        frame.setVisible(true);
    }
}

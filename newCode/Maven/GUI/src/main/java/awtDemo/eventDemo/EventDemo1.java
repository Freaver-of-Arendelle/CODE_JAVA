package awtDemo.eventDemo;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 17:32
 */
public class EventDemo1 {
    Frame frame = new Frame("Here test event deal");

    Button button = new Button("Ok");

    TextField tf = new TextField(30);

    public void init() {
        button.addActionListener(e -> {
            System.out.println("User click the OK button");
            tf.setText("Hello World");
        });

        frame.add(tf);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EventDemo1().init();
    }
}

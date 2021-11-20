package awtDemo.container;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 09:13
 */
public class PaneDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("This is a demo Panel");
        Panel panel = new Panel();

        panel.add(new TextField("This is a test text"));
        panel.add(new Button("This is a test button"));
        frame.add(panel);

        frame.setBounds(100, 100, 500, 300);

        frame.setVisible(true);

    }
}

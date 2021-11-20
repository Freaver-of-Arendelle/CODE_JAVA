package awtDemo.layoutManager;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 09:55
 */
public class BorderLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("Here test border layout");

        frame.setLayout(new BorderLayout(30, 5));

        frame.add(new Button("South button"), BorderLayout.SOUTH);
        frame.add(new Button("North button"), BorderLayout.NORTH);

        Panel panel = new Panel();

        panel.add(new Button("Center button"), BorderLayout.CENTER);
        panel.add(new TextField("This is a text field"));

        frame.add(panel);

        frame.pack();

        frame.setVisible(true);
    }
}

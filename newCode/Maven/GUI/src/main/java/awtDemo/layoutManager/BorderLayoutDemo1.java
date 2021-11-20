package awtDemo.layoutManager;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 09:55
 */
public class BorderLayoutDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("Here test border layout");

        frame.setLayout(new BorderLayout(30, 5));

        frame.add(new Button("East button"), BorderLayout.EAST);
        frame.add(new Button("West button"), BorderLayout.WEST);
        frame.add(new Button("South button"), BorderLayout.SOUTH);
        frame.add(new Button("North button"), BorderLayout.NORTH);
        frame.add(new Button("Center button"), BorderLayout.CENTER);

        frame.pack();

        frame.setVisible(true);
    }
}

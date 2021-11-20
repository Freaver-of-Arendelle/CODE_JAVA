package awtDemo.layoutManager;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 09:44
 */
public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("Here test FlowLayout");
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));

        for (int i = 0; i < 100; i++) {
            frame.add(new Button("button" + i));

            frame.pack();

            frame.setVisible(true);

        }
    }
}

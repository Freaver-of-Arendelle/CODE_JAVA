package awtDemo.layoutManager;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 10:17
 */
public class GridLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("Calculator");

        Panel p1 = new Panel();

        p1.add(new TextField(30));

        frame.add(p1, BorderLayout.NORTH);

        Panel p2 = new Panel();

        p2.setLayout(new GridLayout(3, 5, 4, 4));

        for (int i = 0; i < 10; i++) {
            p2.add(new Button(i + ""));
        }

        p2.add(new Button("+"));
        p2.add(new Button("-"));
        p2.add(new Button("*"));
        p2.add(new Button("/"));
        p2.add(new Button("."));

        frame.add(p2);

        frame.pack();

        frame.setVisible(true);

    }
}

package awtDemo.layoutManager;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Freaver
 * @date 06/29/2021 13:49
 */
public class CardLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();

        String[] names = {"First", "Second", "Third", "Forth", "Fifth"};

        CardLayout cardLayout = new CardLayout();

        Panel p1 = new Panel();
        p1.setLayout(cardLayout);

        for (int i = 0; i < 5; i++) {
            p1.add(names[i], new Button(names[i]));
        }

        Panel p2 = new Panel();

        ActionListener listener = e -> {
            String command = e.getActionCommand();
            switch (command) {
                case "Previous":
                    cardLayout.previous(p1);                    break;
                case "Next":
                    cardLayout.next(p1);
                    break;
                case "First":
                    cardLayout.first(p1);
                    break;
                case "Last":
                    cardLayout.last(p1);
                    break;
                case "Third":
                    cardLayout.show(p1, "Third");
                    break;

            }
        };

        Button b1 = new Button("Previous");
        Button b2 = new Button("Next");
        Button b3 = new Button("First");
        Button b4 = new Button("Last");
        Button b5 = new Button("Third");
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        frame.add(p1);

        frame.add(p2, BorderLayout.SOUTH);



        frame.pack();

        frame.setVisible(true);
    }
}

package awtDemo.component;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 16:35
 */
public class DialogDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("Here test Dialog");
        ;

        Dialog d1 = new Dialog(frame, "Mode Dialog", true);
        Dialog d2 = new Dialog(frame, "Normal Dialog", false);

        Button b1 = new Button("Open mode dialog");
        Button b2 = new Button("Open normal dialog");

        d1.setBounds(20, 30, 300, 400);
        d2.setBounds(20, 30, 300, 400);

        b1.addActionListener(e -> d1.setVisible(true));
        b2.addActionListener(e -> d2.setVisible(true));


        frame.add(b1);
        frame.add(b2, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);



    }
}

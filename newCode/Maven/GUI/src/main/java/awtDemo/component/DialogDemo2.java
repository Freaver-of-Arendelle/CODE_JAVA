package awtDemo.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 16:35
 */
public class DialogDemo2 {
    public static void main(String[] args) {

        Frame frame = new Frame("Here test Dialog");

        Dialog d1 = new Dialog(frame, "Mode Dialog", true);

        Box vBox = Box.createVerticalBox();
        vBox.add(new TextField(25));
        vBox.add(new JButton("Ok"));
        d1.add(vBox);



        Button b1 = new Button("Open mode dialog");

        d1.setBounds(20, 30, 300, 400);
        b1.addActionListener(e -> d1.setVisible(true));


        frame.add(b1);

        frame.pack();
        frame.setVisible(true);



    }
}

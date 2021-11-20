package awtDemo.layoutManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 13:49
 */
public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Box hBox = Box.createHorizontalBox();
        hBox.add(new Button("HorizontalBox1"));
//        hBox.add(Box.createHorizontalGlue());
        hBox.add(new Button("HorizontalBox2"));
        hBox.add(Box.createHorizontalStrut(10));
        hBox.add(new Button("HorizontalBox3"));


        Box vBox = Box.createVerticalBox();
        vBox.add(new Button("VerticalBox1"));
        vBox.add(Box.createVerticalGlue());
        vBox.add(new Button("VerticalBox2"));
        vBox.add(Box.createHorizontalStrut(10));
        vBox.add(new Button("VerticalBox3"));

        frame.add(hBox, BorderLayout.NORTH);
        frame.add(vBox);


        frame.pack();

        frame.setVisible(true);
    }
}

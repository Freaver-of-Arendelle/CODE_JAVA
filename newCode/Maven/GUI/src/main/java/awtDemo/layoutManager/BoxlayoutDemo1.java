package awtDemo.layoutManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 13:49
 */
public class BoxlayoutDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame();

        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.PAGE_AXIS);
        frame.setLayout(boxLayout);

        frame.add(new Button("Button1"));
        frame.add(new Button("Button1"));



        frame.pack();

        frame.setVisible(true);
    }
}

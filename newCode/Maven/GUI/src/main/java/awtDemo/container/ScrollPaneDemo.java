package awtDemo.container;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 09:20
 */
public class ScrollPaneDemo {

    public static void main(String[] args) {
        Frame frame = new Frame();

        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        scrollPane.add(new TextField("This is a test text"));
        scrollPane.add(new Button("This is a test button"));

        frame.add(scrollPane);

        frame.setLocation(100, 100);
        frame.setSize(200, 500);
        frame.setVisible(true);
    }
}

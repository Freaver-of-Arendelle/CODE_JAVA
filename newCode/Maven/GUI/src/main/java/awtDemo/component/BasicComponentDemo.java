package awtDemo.component;


import javax.swing.*;
import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 15:31
 */
public class BasicComponentDemo {
    Frame frame = new Frame("Here test basic awtDemo.component");

    Button ok = new Button("OK");

    CheckboxGroup cbg = new CheckboxGroup();

    Checkbox male = new Checkbox("Man", cbg, true);
    Checkbox female = new Checkbox("Woman", cbg, false);
    Checkbox isMarried = new Checkbox("IsMarried?", false);

    Choice colorChooser = new Choice();

    List colorList = new List(6, true);

    TextArea ta = new TextArea(5, 20);
    TextField tf = new TextField(50);

    public void init() {
        colorChooser.add("Red");
        colorChooser.add("Green");
        colorChooser.add("Blue");

        colorList.add("Red");
        colorList.add("Green");
        colorList.add("Blue");

        Panel bottom = new Panel();
        bottom.add(tf);
        bottom.add(ok);

        frame.add(bottom, BorderLayout.SOUTH);

        Panel checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(isMarried);

        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(checkPanel);

        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        frame.add(top);

        frame.pack();
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new BasicComponentDemo().init();
    }



}

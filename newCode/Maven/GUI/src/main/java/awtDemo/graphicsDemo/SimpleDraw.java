package awtDemo.graphicsDemo;

import java.awt.*;
import java.util.Random;

/**
 * @author Freaver
 * @date 06/30/2021 10:53
 */
public class SimpleDraw {
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";

    private final Frame frame = new Frame("Here test graphic");

    private final Button drawRectBtn = new Button("draw rect");
    private final Button drawOvalBtn = new Button("draw oval");

    private String shape = "";

    private final MyCanvas drawArea = new MyCanvas();

    public void init() {
        drawRectBtn.addActionListener(e -> {
            shape = RECT_SHAPE;
            drawArea.repaint();
        });

        drawOvalBtn.addActionListener(e -> {
            shape = OVAL_SHAPE;
            drawArea.repaint();
        });

        Panel p = new Panel();
        p.add(drawRectBtn);
        p.add(drawOvalBtn);

        frame.add(p, BorderLayout.SOUTH);

        drawArea.setPreferredSize(new Dimension(300, 200));

        frame.add(drawArea);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDraw().init();
    }


    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics graphics) {
            Random r = new Random();

            if (shape.equals(RECT_SHAPE)) {
                graphics.setColor(Color.BLACK);
                graphics.drawRect(r.nextInt(200), r.nextInt(100), 40 ,60);
            }

            if (shape.equals(OVAL_SHAPE)) {
                graphics.setColor(Color.RED);
                graphics.drawOval(r.nextInt(200), r.nextInt(100), 60, 40 );
            }


        }
    }
}



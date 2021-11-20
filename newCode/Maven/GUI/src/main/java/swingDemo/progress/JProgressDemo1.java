package swingDemo.progress;

import javax.swing.*;
import java.awt.*;

/**
 * @author Freaver
 * @date 07/01/2021 19:24
 */
public class JProgressDemo1 {
    JFrame jf = new JFrame("test progress bar");

    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL);

    JCheckBox indeterminate = new JCheckBox("undifine progress");
    JCheckBox noBOrder = new JCheckBox("no border");

    public void init() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(indeterminate);
        box.add(noBOrder);

        jf.setLayout(new FlowLayout());
        jf.add(box);

        jf.add(bar);

        bar.setMinimum(0);
        bar.setMaximum(100);

        bar.setStringPainted(true);

        noBOrder.addActionListener(e -> {
            boolean selected = noBOrder.isSelected();
            bar.setBorderPainted(!selected);
        });

        indeterminate.addActionListener(e -> {
            boolean selected = indeterminate.isSelected();
            bar.setIndeterminate(selected);
            bar.setStringPainted(!selected);
        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        for (int i = 0; i < 100; i++) {
            bar.setValue(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new JProgressDemo1().init();
    }

}

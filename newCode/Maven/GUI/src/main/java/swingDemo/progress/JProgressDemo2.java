package swingDemo.progress;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

/**
 * @author Freaver
 * @date 07/01/2021 19:24
 */
public class JProgressDemo2 {
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

        SimulatedActivity simulatedActivity = new SimulatedActivity(100);
        new Thread(simulatedActivity).start();

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

        Timer timer = new Timer(300, e -> {
            bar.setValue(simulatedActivity.getCurrent());
        });

        timer.start();

        bar.addChangeListener(e -> {
            if (bar.getValue() == bar.getMaximum()) {
                timer.stop();
            }
        });
    }

    public static void main(String[] args) {
        new JProgressDemo2().init();
    }


    private class SimulatedActivity implements Runnable {
        private volatile int current = 0;
        private int amount;

        public int getCurrent() {
            return this.current;
        }

        public void setCurrent(final int current) {
            this.current = current;
        }

        public int getAmount() {
            return this.amount;
        }

        public void setAmount(final int amount) {
            this.amount = amount;
        }

        public SimulatedActivity(final int amount) {
            this.amount = amount;
        }

        @Override
        public void run() {
            while (current < amount) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current++;
            }
        }

    }


}

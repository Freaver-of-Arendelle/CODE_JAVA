import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;
import javax.swing.event.AncestorListener;

public class InnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showInputDialog(null, "Quit program?");
        System.out.println(0);

    }
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        var listener = new TimerPrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimerPrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is" + 
            Instant.ofEpochMilli(event.getWhen()));
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }

        }
    }


}

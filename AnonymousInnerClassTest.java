import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock1();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }

}

class TalkingClock1 {
    public void start(int interval, boolean beep) {
        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
            
        };
        var timer = new Timer(interval, listener);
            timer.start();
        
    }

    // public void start(int interval, boolean beep) {
    // Timer timer = new Timer(interval, event -> {
    // System.out.println("At the tone, the time is " +
    // Instant.ofEpochMilli(event.getWhen()));
    // if (beep) {
    // Toolkit.getDefaultToolkit().beep();
    // }
    // timer.start();

    // });
    // }
    // var timer = new Timer(interval, listener);
}

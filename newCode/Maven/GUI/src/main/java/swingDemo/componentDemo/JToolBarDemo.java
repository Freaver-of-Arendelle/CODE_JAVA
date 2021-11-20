package swingDemo.componentDemo;

import com.sun.tools.javac.Main;

import javax.crypto.interfaces.PBEKey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Freaver
 * @date 07/01/2021 10:47
 */
public class JToolBarDemo {
    JFrame jf = new JFrame("test toolbar");

    JTextArea jta = new JTextArea(6, 35);

    JToolBar jtb = new JToolBar();

    Action pre = new AbstractAction("Pre", new ImageIcon("img/component/pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("Pre.\n");
        }
    };

    Action pause = new AbstractAction("Pause", new ImageIcon("img/component/pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("pause.\n");
        }
    };

    Action next = new AbstractAction("Next", new ImageIcon("img/component/next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("Next.\n");
        }
    };

    public void init() {
        jf.add(new JScrollPane(jta));
        JButton preBtn = new JButton(pre);
        JButton pauseBtn = new JButton(pause);
        JButton nextBtn = new JButton(next);

        jtb.add(preBtn);
        jtb.addSeparator();
        jtb.add(pauseBtn);
        jtb.addSeparator();
        jtb.add(nextBtn);

        jf.add(jtb, BorderLayout.NORTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        jf.setVisible(true);


    }

    public static void main(String[] args) {
        new JToolBarDemo().init();

    }

}

package swingDemo.componentDemo;

import javax.swing.*;
import javax.swing.border.*;
import javax.xml.crypto.Data;
import java.awt.*;

/**
 * @author Freaver
 * @date 07/01/2021 10:09
 */
public class BorderDemo {
    JFrame jf = new JFrame("test border");


    public void init() {
        jf.setLayout(new GridLayout(2, 4));

        Border lb = BorderFactory.createLineBorder(Color.ORANGE, 10);
        jf.add(getPanelWithBorder(lb, "LineBorder"));

        Border eb = BorderFactory.createEmptyBorder(20, 5, 10, 30);
        jf.add(getPanelWithBorder(eb, "EmptyBorder"));

        Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
        jf.add(getPanelWithBorder(bb, "BevelBOrder"));

        Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED, Color.GREEN);
        jf.add(getPanelWithBorder(etb, "EtchedBorder"));

        Border tb = BorderFactory.createTitledBorder(new TitledBorder(lb, "Test Title", TitledBorder.LEFT, TitledBorder.BOTTOM, new Font("STSong", Font.BOLD, 18), Color.BLUE));
        jf.add(getPanelWithBorder(tb, "TitledBorder"));

        MatteBorder mb = new MatteBorder(20, 5, 10, 30, Color.GREEN);
        jf.add(getPanelWithBorder(mb, "MatteBorder"));

        CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED, 8), tb);
        jf.add(getPanelWithBorder(cb, "CompoundBorder"));

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public JPanel getPanelWithBorder(Border border, String borderName) {
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel(borderName));

        jPanel.setBorder(border);

        return jPanel;
    }

    public static void main(String[] args) {
        new BorderDemo().init();
    }

}

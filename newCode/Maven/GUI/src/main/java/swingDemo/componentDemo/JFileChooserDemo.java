package swingDemo.componentDemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Freaver
 * @date 07/01/2021 13:46
 */
public class JFileChooserDemo {

    BufferedImage image;

    JPanel drawArea = new MyCanvas();

    JFrame jf = new JFrame("test jFileChooser");


    JFileChooser chooser = new JFileChooser(".");

    JMenuBar jmb = new JMenuBar();

    JMenu jMenu = new JMenu("file");

    JMenuItem open = new JMenuItem(new AbstractAction("open") {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.showOpenDialog(jf);
            File imageFile = chooser.getSelectedFile();
            try {
                image = ImageIO.read(imageFile);
                drawArea.repaint();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    });

    JMenuItem save = new JMenuItem(new AbstractAction("save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            chooser.showOpenDialog(jf);
            File dir = chooser.getSelectedFile();
            try {
                ImageIO.write(image, "jpeg", new File(dir, "a.jpg"));
                drawArea.repaint();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    });

    class MyCanvas extends JPanel {
        @Override
        public void paint(final Graphics g) {
            if (image != null) {
                g.drawImage(image, 0, 0, null);
            }
        }
    }

    public void init() {
        drawArea.setPreferredSize(new Dimension(500, 300));
        jf.add(drawArea);

        jMenu.add(open);
        jMenu.add(save);
        jmb.add(jMenu);
        jf.setJMenuBar(jmb);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JFileChooserDemo().init();
    }
}

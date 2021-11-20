package awtDemo.component;

import java.awt.*;

/**
 * @author Freaver
 * @date 06/29/2021 16:52
 */
public class FileDialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
        FileDialog d1 = new FileDialog(frame, "Choose the file to load", FileDialog.LOAD);
        FileDialog d2 = new FileDialog(frame, "Choose the file to save", FileDialog.SAVE);

        Button b1 = new Button("Open file");
        Button b2 = new Button("Save file");

        b1.addActionListener(e -> {
            d1.setVisible(true);
            System.out.println("The file location user choose: "
                    + d1.getDirectory());
            System.out.println("The file name user choose: "
                    + d1.getFile());
        });

        System.out.println("========================================");

        b2.addActionListener(e -> {
            d2.setVisible(true);
            System.out.println("The file location user choose: "
                    + d2.getDirectory());
            System.out.println("The file name user choose: "
                    + d2.getFile());
        });

        frame.add(b1);
        frame.add(b2, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

    }
}

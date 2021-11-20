package awtDemo.menuDemo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Freaver
 * @date 06/29/2021 13:49
 */
public class PopupMenuDemo {
    private Frame frame = new Frame();

    private PopupMenu popupMenu = new PopupMenu();

    private MenuItem annotationItem = new MenuItem("annotation");
    private MenuItem cancelItem = new MenuItem("cancel");
    private MenuItem copyItem = new MenuItem("copy");
    private MenuItem paseteItem = new MenuItem("paste");

    private TextArea ta = new TextArea("I love China", 6, 40);

    private Panel panel = new Panel();

    public void init() {

        popupMenu.add(annotationItem);
        popupMenu.add(cancelItem);
        popupMenu.add(copyItem);
        popupMenu.add(paseteItem);

        panel.setPreferredSize(new Dimension(300, 100));

        panel.add(popupMenu);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if(mouseEvent.isPopupTrigger()) {
                    popupMenu.show(panel, mouseEvent.getX(), mouseEvent.getY());
                }
            }
        });


        frame.add(ta);

        frame.add(panel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String[] args) {

        new PopupMenuDemo().init();
    }
}

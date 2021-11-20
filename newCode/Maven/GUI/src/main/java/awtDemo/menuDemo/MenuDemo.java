package awtDemo.menuDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Freaver
 * @date 06/30/2021 09:20
 */
public class MenuDemo {
    private Frame frame = new Frame("Here test menu");
    private MenuBar menuBar = new MenuBar();
    private Menu fileMenu = new Menu("File");
    private Menu editMenu = new Menu("edit");
    private MenuItem newItem = new MenuItem("new");
    private MenuItem saveItem = new MenuItem("save");
    private MenuItem exitItem = new MenuItem("exit");

    private CheckboxMenuItem autoWrap = new CheckboxMenuItem("auto wrap");

    private MenuItem copyItem = new MenuItem("copy");

    private MenuItem pasteItem = new MenuItem("paste");

    private Menu formatMenu = new Menu("format");

    private MenuItem annotationItem = new MenuItem("annotation");

    private MenuItem cancelItem = new MenuItem("cancelItem");

    private TextArea ta = new TextArea(6, 40);


    public void init() {

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String command = actionEvent.getActionCommand();
                ta.append("click " + command + " menu\n");
                if (command.equals("exit")) {
                    System.exit(0);
                }
            }
        };

        annotationItem.addActionListener(listener);
        exitItem.addActionListener(listener);

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        editMenu.add(autoWrap);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        formatMenu.add(annotationItem);
        formatMenu.add(cancelItem);

        editMenu.add(new MenuItem("-"));
        editMenu.add(formatMenu);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setMenuBar(menuBar);

        frame.add(ta);

        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {

        new MenuDemo().init();

    }
}

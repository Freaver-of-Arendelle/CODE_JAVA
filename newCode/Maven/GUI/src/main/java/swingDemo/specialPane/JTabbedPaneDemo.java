package swingDemo.specialPane;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Freaver
 * @date 07/01/2021 17:17
 */
public class JTabbedPaneDemo {
    JFrame jf = new JFrame("test JTabbedPane");

    JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

    public void init() {

        jf.setBounds(400, 400, 400, 400);
        jf.setResizable(false);

        ImageIcon icon = new ImageIcon("img/container/open.gif");

        tabbedPane.addTab("用户管理", icon, new JList<String>(new String[]{"用户一", "用户二", "用户三"}));
        tabbedPane.addTab("商品管理", new JList<String>(new String[]{"商品一", "商品二", "商品三"}));
        tabbedPane.addTab("订单管理", icon, new JList<String>(new String[]{"订单一", "订单二", "订单三"}));

        tabbedPane.setSelectedIndex(1);

        tabbedPane.setEnabledAt(0, false);

        tabbedPane.addChangeListener(e -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            JOptionPane.showMessageDialog(jf, "Selected number " +
                    (selectedIndex + 1) + "Labels");
        });

        jf.add(tabbedPane);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JTabbedPaneDemo().init();
    }
}

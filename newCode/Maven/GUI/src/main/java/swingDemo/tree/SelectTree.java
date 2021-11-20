package swingDemo.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Freaver
 * @date 07/02/2021 15:30
 */
public class SelectTree {
    JFrame jf = new JFrame("监听树的选择事件");

    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    JTextArea eventTxt = new JTextArea(5, 20);

    public void init() {
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree = new JTree(root);

        tree.addTreeSelectionListener(e -> {
            if (e.getOldLeadSelectionPath() != null) {
                eventTxt.append(e.getOldLeadSelectionPath().toString() + "\n");
            }

            eventTxt.append(e.getNewLeadSelectionPath().toString() + "\n");
        });

        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);

        Box box = Box.createHorizontalBox();
        box.add(new JScrollPane(tree));
        box.add(new JScrollPane(eventTxt));

        jf.add(box);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectTree().init();
    }
}

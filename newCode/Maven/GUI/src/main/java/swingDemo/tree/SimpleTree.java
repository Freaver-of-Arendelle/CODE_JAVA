package swingDemo.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author Freaver
 * @date 07/02/2021 14:57
 */
public class SimpleTree {
    JFrame jf = new JFrame("simple tree");

    JTree jTree;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode guangdong;
    DefaultMutableTreeNode guangxi;
    DefaultMutableTreeNode foshan;
    DefaultMutableTreeNode shantou;
    DefaultMutableTreeNode guilin;
    DefaultMutableTreeNode nanning;

    public void init() {
        root = new DefaultMutableTreeNode("China");
        guangdong = new DefaultMutableTreeNode("guangdong");
        guangxi = new DefaultMutableTreeNode("guangxi");
        foshan = new DefaultMutableTreeNode("foshan");
        shantou = new DefaultMutableTreeNode("shantou");
        guilin = new DefaultMutableTreeNode("guilin");
        nanning = new DefaultMutableTreeNode("nanning");

        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        jTree = new JTree(root);

        jf.add(new JScrollPane(jTree));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTree().init();
    }

}

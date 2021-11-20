package swingDemo.specialPane;

import javax.swing.*;
import java.awt.*;
import java.awt.print.Book;


/**
 * @author Freaver
 * @date 07/01/2021 17:04
 */
public class JSplitPaneDemo {

    Book[] books = {new Book("java自学宝典", new ImageIcon("img/container/java.png"), "国内关于 Java 编程最全面的图书 \n 看得懂 ， 学得会"),
            new Book("轻量级的JAVAEE企业应用实战", new ImageIcon("img/container/ee.png"), "SSM整合开发的经典图书，值的拥有"),

            new Book("Android基础教程", new ImageIcon("img/container/android.png"), "全面介绍Android平台应用程序\n 开发的各方面知识")

    };

    JFrame jf = new JFrame("test JSplitPane");

    JList<Book> bookJList = new JList<Book>(books);

    JLabel bookCover = new JLabel();

    JTextArea bookDesc = new JTextArea();

    public void init() {
        bookJList.setPreferredSize(new Dimension(150, 400));
        bookCover.setPreferredSize(new Dimension(220, 330));
        bookDesc.setPreferredSize(new Dimension(220, 70));

        bookJList.addListSelectionListener(e -> {
            Book book = bookJList.getSelectedValue();
            bookCover.setIcon(book.getIcon());
            bookDesc.setText(book.getDesc());
        });

        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bookCover, new JScrollPane(bookDesc));

        left.setOneTouchExpandable(true);

        left.setOneTouchExpandable(true);

        left.resetToPreferredSizes();

        JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, this.bookJList);

        content.setContinuousLayout(true);

        jf.add(content);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JSplitPaneDemo().init();
    }

    class Book {
        private String name;

        private Icon icon;

        private String desc;

        public Book(final String name, final Icon icon, final String desc) {
            this.name = name;
            this.icon = icon;
            this.desc = desc;
        }

        public String getName() {
            return this.name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public Icon getIcon() {
            return this.icon;
        }

        public void setIcon(final Icon icon) {
            this.icon = icon;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setDesc(final String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

}



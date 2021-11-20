package swingDemo.table;

import javax.swing.*;

/**
 * @author Freaver
 * @date 07/03/2021 00:45
 */
public class SimpleTable {
    JFrame jf = new JFrame("simple table");

    JTable table;

    Object[][] tableData = {
            new Object[]{"李清照",29,"女"},
            new Object[]{"苏格拉底",56,"男"},
            new Object[]{"李白",35,"男"},
            new Object[]{"弄玉",18,"女"},
            new Object[]{"虎头",2,"男"},
    };

    Object[] columnTitle = {"name", "age", "gender" };

    public void init() {
        table = new JTable(tableData, columnTitle);

        jf.add(new JScrollPane(table));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTable().init();
    }
}

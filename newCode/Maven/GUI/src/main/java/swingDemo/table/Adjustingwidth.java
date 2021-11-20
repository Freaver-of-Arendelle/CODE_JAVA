package swingDemo.table;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * @author Freaver
 * @date 07/03/2021 00:45
 */
public class Adjustingwidth {
    JFrame jf = new JFrame("simple table");

    JMenuBar menuBar = new JMenuBar();

    JMenu adjustModeMenu = new JMenu("adjust way");
    JMenu selectUnitMenu = new JMenu("option cell");
    JMenu selectModeMenu = new JMenu("option way");

    JRadioButtonMenuItem[] adjustModeItem = new JRadioButtonMenuItem[5];

    JRadioButtonMenuItem[] selectModeItem = new JRadioButtonMenuItem[3];

    JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("select row");
    JCheckBoxMenuItem columnItem = new JCheckBoxMenuItem("select columItem");
    JCheckBoxMenuItem cellItem = new JCheckBoxMenuItem("select cell");

    ButtonGroup adjustBg = new ButtonGroup();
    ButtonGroup selectBg = new ButtonGroup();

    int[] adjustModes = {
            JTable.AUTO_RESIZE_OFF,
            JTable.AUTO_RESIZE_NEXT_COLUMN,
            JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS,
            JTable.AUTO_RESIZE_LAST_COLUMN,
            JTable.AUTO_RESIZE_ALL_COLUMNS,
    };

    int[] selectModes = {
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION,
            ListSelectionModel.SINGLE_INTERVAL_SELECTION,
            ListSelectionModel.SINGLE_SELECTION
    };

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

        adjustModeItem[0] = new JRadioButtonMenuItem("只调整表格");
        adjustModeItem[1] = new JRadioButtonMenuItem("只调整下一列");
        adjustModeItem[2] = new JRadioButtonMenuItem("平均调整余下列");
        adjustModeItem[3] = new JRadioButtonMenuItem("只调整最后一列");
        adjustModeItem[4] = new JRadioButtonMenuItem("平均调整所有列");

        menuBar.add(adjustModeMenu);

        for (int i = 0; i < adjustModes.length; i++) {
            if (i == 2 ) {
                adjustModeItem[i].setSelected(true);
            }

            adjustBg.add(adjustModeItem[i]);
            adjustModeMenu.add(adjustModeItem[i]);

            int index = i;
            adjustModeItem[i].addActionListener(e -> {
                if (adjustModeItem[index].isSelected()) {
                    table.setAutoResizeMode(adjustModes[index]);
                }
            });
        }

        adjustModeItem[0] = new JRadioButtonMenuItem("只调整表格");
        adjustModeItem[1] = new JRadioButtonMenuItem("只调整下一列");
        adjustModeItem[2] = new JRadioButtonMenuItem("平均调整余下列");
        adjustModeItem[3] = new JRadioButtonMenuItem("只调整最后一列");
        adjustModeItem[4] = new JRadioButtonMenuItem("平均调整所有列");


        menuBar.add(selectModeMenu);

        for (int i = 0; i < adjustModeItem.length; i++) {
            if (i == 2) {
                adjustModeItem[i].setSelected(true);
            }

            adjustBg.add(adjustModeItem[i]);
            adjustModeMenu.add(adjustModeItem[i]);

            int index = i;
            adjustModeItem[i].addActionListener(e -> {
                if (adjustModeItem[index].isSelected()) {
                    table.setAutoResizeMode(adjustModes[index]);
                }
             });
        }

        selectModeItem[0] = new JRadioButtonMenuItem("无限制");
        selectModeItem[1] = new JRadioButtonMenuItem("单独的连续区");
        selectModeItem[2] = new JRadioButtonMenuItem("单选");

        menuBar.add(selectModeMenu);

        for (int i = 0; i < selectModeItem.length; i++) {

            if (i == 0) {
                selectModeItem[i].setSelected(true);
            }

            selectBg.add(selectModeItem[i]);
            selectModeMenu.add(selectModeItem[i]);

            int index = i;

            selectModeItem[i].addActionListener(e -> {
                if (selectModeItem[index].isSelected()) {
                    table.getSelectionModel().setSelectionMode(selectModes[index]);
                }
            });
        }


        menuBar.add(selectUnitMenu);
        rowsItem.setSelected(table.getRowSelectionAllowed());
        columnItem.setSelected(table.getColumnSelectionAllowed());
        cellItem.setSelected(table.getCellSelectionEnabled());

        rowsItem.addActionListener(e -> {
            table.clearSelection();

            table.setRowSelectionAllowed(rowsItem.isSelected());

            table.setCellSelectionEnabled(table.getCellSelectionEnabled());
        });

        selectUnitMenu.add(rowsItem);

        columnItem.addActionListener(e -> {
            table.clearSelection();

            table.setColumnSelectionAllowed(columnItem.isSelected());

            table.setCellSelectionEnabled(table.getCellSelectionEnabled());
        });

        selectUnitMenu.add(columnItem);

        cellItem.addActionListener(e -> {
            table.clearSelection();

            table.setCellSelectionEnabled(cellItem.isSelected());

            table.setRowSelectionAllowed(table.getRowSelectionAllowed());
            table.setColumnSelectionAllowed(table.getColumnSelectionAllowed());
        });

        selectUnitMenu.add(cellItem);

        jf.setJMenuBar(menuBar);

        TableColumn nameColumn = table.getColumn(columnTitle[0]);
        nameColumn.setMinWidth(40);
        TableColumn ageColumn = table.getColumn(columnTitle[1]);
        ageColumn.setPreferredWidth(50);
        TableColumn genderColumn = table.getColumn(columnTitle[2]);
        genderColumn.setMaxWidth(50);

        jf.add(new JScrollPane(table));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Adjustingwidth().init();
    }
}

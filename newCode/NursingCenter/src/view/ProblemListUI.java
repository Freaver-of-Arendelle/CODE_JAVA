/*
 * Created by JFormDesigner on Thu Jul 15 11:24:51 CST 2021
 */

package view;

import controller.ProblemController;
import controller.TemplateController;
import model.bean.Problem;
import model.bean.Template;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Vector;

/**
 * @author Freaver
 */
public class ProblemListUI extends JFrame {

    private static ProblemController controller = ProblemController.getSingleton();

    private static Vector<Problem> vector = new Vector<>(controller.getProblems());

    /**
     * 用来记录被删除的问题的id
     */
    private static Set<Integer> removeIds = new HashSet<>();

    /**
     * 与Problem中的reflect产生对应
     */
//    private static List<Map<String, Set<Integer>>> reflects = new ArrayList<>();

    private static int id;


    /**
     * 根据提供的vector对JComboBox进行初始化
     *
     * @param selCB
     * @param vector
     */
    private static void selInit(JComboBox selCB, Vector<Problem> vector) {
        Set<String> strings = new HashSet<>();
        strings.add("请选择问题类型");
        selCB.removeAllItems();
        for (Problem problem : vector) {
            strings.add(problem.getType());
        }
        for (String s : strings) {
            selCB.addItem(s);
        }
    }

    /**
     * 根据提供的vector来初始化model
     *
     * @param model
     * @param vector
     */
    private static void init(DefaultTableModel model, Vector<Problem> vector) {
        int size = vector.size();
//        if (size > 0) {
        for (int i = 0; i < size; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(false);
            vector1.add(vector.get(i).getId());
            vector1.add(vector.get(i).getQuestion());
            vector1.add(vector.get(i).getType());
            model.addRow(vector1);
        }
    }


    /**
     * 根据提供的model和vector来调用init方法并且重绘
     *
     * @param model
     * @param vector
     */
    private void refresh(DefaultTableModel model, Vector<Problem> vector) {
        model.getDataVector().clear();
        init(model, vector);
        table1.setModel(model);
        table1.repaint();
//        scrollPane1.repaint();
    }

    public ProblemListUI() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        selInit(selCB, vector);
        refresh(model, vector);
    }

    /**
     * 删除监听器
     * @param e
     */
    private void delBtnActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        for (int i = 0; i < table1.getRowCount(); i++) {
            if (table1.getValueAt(i, 0).equals(true)) {
                int tempID = (int) table1.getValueAt(i, 1);
                vector.removeIf(c -> c.getId() == tempID);
                removeIds.add(id);
//                reflects.add(vector.get(i).getReflect());
            }
        }
        selInit(selCB, vector);
        refresh(model, vector);

    }

    private void detailBTnActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, vector.get(table1.getSelectedRow()).getAnswers());
    }

    private void newBtnActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        Vector<Problem> blankVector = new Vector<>();
        model.addRow(blankVector);
        int count = table1.getRowCount();
        table1.requestFocus();
        table1.setRowSelectionInterval(count - 1, count - 1);
        table1.editCellAt(count - 1, 0);
    }

    private void returnBtnActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void okBtnActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        Vector<Vector> dataVector = model.getDataVector();
        for (Vector vector1 : dataVector) {
            controller.addProblem(new Problem(((int) vector1.get(1)),
                    ((String) vector1.get(2)), null, null, null));
        }

        Vector<Template> templates = TemplateListUI.getVector();
//       获取所有的template
        for (Template template : templates) {

//            获取每个template所对应的problems
            Set<Problem> problems = template.getProblems();

//            根据removeId来删除template中对应的problem
            for (Integer removeId : removeIds) {
                problems.removeIf(c -> c.getId().equals(removeId));
            }
        }
//        for (Integer removeId : removeIds) {
//            Set<Integer> integers = reflects.get(removeId).get(removeId);
//            for (Integer integer : integers) {
//                Template template = templates.get(integer);
//                template.getProblems().removeIf(c -> c.getId().equals(removeId));
//            }
//        }
        TemplateController templateController = TemplateListUI.getController();

        templateController.clear();
        for (Template template : templates) {
            templateController.addTemplate(template);
        }

        this.dispose();
    }

    private void selCBActionPerformed(ActionEvent e) {
        String type = (String) selCB.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        if (!type.equals("请选择问题类型")) {
            Vector<Problem> problems = new Vector<>(vector);
            problems.removeIf(c -> !c.getType().equals(type));
            refresh(model, problems);
        } else {
            refresh(model, vector);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("problemList");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        buttonBar = new JPanel();
        okBtn = new JButton();
        returnBtn = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        selCB = new JComboBox();
        delBtn = new JButton();
        detailBTn = new JButton();
        newBtn = new JButton();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== buttonBar ========
                {
                    buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                    //---- okBtn ----
                    okBtn.setText(bundle.getString("okBtn.text"));
                    okBtn.addActionListener(e -> okBtnActionPerformed(e));

                    //---- returnBtn ----
                    returnBtn.setText(bundle.getString("returnBtn.text"));
                    returnBtn.addActionListener(e -> returnBtnActionPerformed(e));

                    GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                    buttonBar.setLayout(buttonBarLayout);
                    buttonBarLayout.setHorizontalGroup(
                        buttonBarLayout.createParallelGroup()
                            .addGroup(buttonBarLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(okBtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                                .addComponent(returnBtn)
                                .addGap(50, 50, 50))
                    );
                    buttonBarLayout.setVerticalGroup(
                        buttonBarLayout.createParallelGroup()
                            .addGroup(buttonBarLayout.createSequentialGroup()
                                .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(okBtn)
                                    .addComponent(returnBtn))
                                .addGap(0, 11, Short.MAX_VALUE))
                    );
                }

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            " ", "ID", "\u9898\u76ee", "\u7c7b\u578b"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Boolean.class, Integer.class, String.class, String.class
                        };
                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }
                    });
                    scrollPane1.setViewportView(table1);
                }

                //---- selCB ----
                selCB.addActionListener(e -> selCBActionPerformed(e));

                //---- delBtn ----
                delBtn.setText(bundle.getString("delBtn.text"));
                delBtn.addActionListener(e -> delBtnActionPerformed(e));

                //---- detailBTn ----
                detailBTn.setText(bundle.getString("detailBTn.text"));
                detailBTn.addActionListener(e -> detailBTnActionPerformed(e));

                //---- newBtn ----
                newBtn.setText(bundle.getString("newBtn.text"));
                newBtn.addActionListener(e -> newBtnActionPerformed(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(selCB, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 382, Short.MAX_VALUE))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(buttonBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(delBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                                    .addComponent(detailBTn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(newBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5))
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addComponent(selCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(delBtn)
                                .addComponent(detailBTn)
                                .addComponent(newBtn))
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel buttonBar;
    private JButton okBtn;
    private JButton returnBtn;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JComboBox selCB;
    private JButton delBtn;
    private JButton detailBTn;
    private JButton newBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

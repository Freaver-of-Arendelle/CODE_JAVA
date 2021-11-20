/*
 * Created by JFormDesigner on Wed Jul 14 23:34:20 CST 2021
 */

package view;

import controller.ProblemController;
import controller.TemplateController;
import model.bean.Problem;
import model.bean.Template;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Freaver
 */
public class TemplateListUI extends JFrame {


    private static TemplateController controller = TemplateController.getSingleton();

    private static final Vector<Template> vector = new Vector<>(controller.getTemplates());

    private static Problem problem;

    private static Vector<Problem> tempVector;

    public TemplateListUI() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        selInit(selCB, vector);
        refresh1(model, vector);
    }


    public static TemplateController getController() {
        return controller;
    }

    public static Vector<Template> getVector() {
        return vector;
    }

    /**
     * 根据提供的vector对JComboBox进行初始化
     *
     * @param selCB
     * @param vector
     */
    private static void selInit(JComboBox selCB, Vector<Template> vector) {
        Vector<String> strings = new Vector<>();
        strings.add("请选择模板类型");
        selCB.removeAllItems();
        for (Template template : vector) {
            strings.add(template.getType());
        }

        for (String s : strings) {
            selCB.addItem(s);
        }
    }

    public static void main(String[] args) {
        TemplateListUI ui = new TemplateListUI();
        ui.setVisible(true);
    }


    /**
     * 根据提供的vector来初始化model
     *
     * @param model
     * @param vector
     */
    private static void init1(DefaultTableModel model, Vector<Template> vector) {
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(false);
            vector1.add(vector.get(i).getId());
            vector1.add(vector.get(i).getTitle());
            vector1.add(vector.get(i).getType());
            model.addRow(vector1);
        }
    }

    /**
     * 根据提供的vector来初始化model
     *
     * @param model
     * @param vector
     */
    private static void init2(DefaultTableModel model, Vector<Problem> vector) {
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(false);
            vector1.add(vector.get(i).getId());
            vector1.add(vector.get(i).getQuestion());
            model.addRow(vector1);
        }
    }

    /**
     * 根据提供的model和vector来调用init方法并且重绘
     *
     * @param model
     * @param vector
     */
    private void refresh1(DefaultTableModel model, Vector<Template> vector) {
        model.getDataVector().clear();
        TemplateListUI.init1(model, vector);
        table1.setModel(model);
        table1.repaint();
//        scrollPane1.repaint();
    }


    /**
     * 根据提供的model和vector来调用init方法并且重绘
     *
     * @param model
     * @param vector
     */
    private void refresh2(DefaultTableModel model, Vector<Problem> vector) {
        model.getDataVector().clear();
        TemplateListUI.init2(model, vector);
        table2.setModel(model);
        table2.repaint();
//        scrollPane1.repaint();
    }

    private void saveButtonActionPerformed(ActionEvent e) {
        Set<Template> set = new TreeSet<>(vector);
        List<Template> list = new ArrayList<>(set);
        Integer maxId = list.get(list.size() - 1).getId();
        controller.clear();
        for (Template template : set) {
            if (template.getId() == null) {
                template.setId(maxId++);
            }
            controller.addTemplate(template);
        }
        this.dispose();

    }

    private void saveBtnActionPerformed(ActionEvent e) {
        Template template = vector.get(table1.getSelectedRow());
        DefaultTableModel model = (DefaultTableModel) table2.getModel();

        ProblemController problemController = ProblemController.getSingleton();
        problemController.modifyProblem(problem.getId(), problem);

        //        Vector<Vector> dataVector = model.getDataVector();
//        if (tempVector != null) {
//            tempVector.clear();
//            for (Vector vector1 : dataVector) {
//                tempVector.add(new Problem(((int) vector1.get(1)),
//                        ((String) vector1.get(2)), null, null, null));
//            }
//        } else {
//            tempVector = new Vector<>();
//            for (Vector vector1 : dataVector) {
//                tempVector.add(new Problem(((int) vector1.get(1)),
//                        ((String) vector1.get(2)), null, null, null));
//            }
//    }

        template.setProblems(new HashSet<>(tempVector));
        frame1.dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void newBtnActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        Vector<Template> blankVector = new Vector<>();
        model.addRow(blankVector);
        int count = table1.getRowCount();
        table1.requestFocus();
        table1.setRowSelectionInterval(count - 1, count - 1);
        table1.editCellAt(count - 1, 0);

    }

    /**
     * 模板删除监听器
     *
     * @param e
     */
    private void delBTnActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        for (int i = 0; i < table1.getRowCount(); i++) {
            if (table1.getValueAt(i, 0).equals(true)) {
                int id = (int) table1.getValueAt(i, 1);
                vector.removeIf(c -> c.getId() == id);
//                获取problems
                List<Problem> problems = new ArrayList<>(vector.get(i).getProblems());

                for (int j = 0; j < problems.size(); j++) {
//                    根据对应的序号获取problem对应的reflect
                    Set<Integer> reflect = problems.get(j).getReflect();
//                    根据id删除相对应模板
                    reflect.removeIf(c -> c == id);
                }
            }
        }
        selInit(selCB, vector);
        refresh1(model, vector);


    }

    private void viewBtnActionPerformed(ActionEvent e) {
        Template template = vector.get(table1.getSelectedRow());
        nameLabel.setText("模板" + template.getId());
        refresh2((DefaultTableModel) table2.getModel(), new Vector<>(template.getProblems()));
        frame1.setVisible(true);
    }

    private void selComboBoxActionPerformed(ActionEvent e) {
        String type = (String) selCB.getSelectedItem();

        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        if (!"请选择模板类型".equals(type)) {
            Vector<Template> templates = new Vector<>(vector);
            templates.removeIf(c -> !c.getType().equals(type));
            refresh1(model, templates);
        } else {
            refresh1(model, vector);
        }

//        Vector<Template> templates = vector;
//        templates.removeIf(c -> !c.getType().equals(type));
//        refresh1(((DefaultTableModel) table1.getModel()), vector);
    }

    /**
     * 删除单个模板中对应的problem
     *
     * @param e
     */
    private void delBtn2ActionPerformed(ActionEvent e) {

        DefaultTableModel model = (DefaultTableModel) table2.getModel();


        Template template = vector.get(table1.getSelectedRow());
        tempVector = new Vector<>(template.getProblems());
        for (int i = 0; i < table2.getRowCount(); i++) {
            if (table2.getValueAt(i, 0).equals(true)) {
                int id = (int) table2.getValueAt(i, 1);
                problem = tempVector.get(i);
                tempVector.removeIf(c -> c.getId() == id);
                //                获取problems
                int finalI = i;
                problem.getReflect().removeIf(c -> c == id);


            }
        }
        refresh2(model, new Vector<>(tempVector));


    }

    private void cancelBtn2ActionPerformed(ActionEvent e) {
        frame1.dispose();

    }

    private void addBtnActionPerformed(ActionEvent e) {
//        DefaultTableModel model = (DefaultTableModel) table2.getModel();
//        Vector<Problem> blankVector = new Vector<>();
//        model.addRow(blankVector);
//        int count = table2.getRowCount();
//        table2.requestFocus();
//        table2.setRowSelectionInterval(count - 1, count - 1);
//        table2.editCellAt(count - 1, 0);
        new ProblemListUI().setVisible(true);
        refresh1(((DefaultTableModel) table1.getModel()), vector);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("templateList");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        viewBtn = new JButton();
        delBTn = new JButton();
        newBtn = new JButton();
        selCB = new JComboBox();
        buttonBar = new JPanel();
        saveButton = new JButton();
        cancelButton = new JButton();
        frame1 = new JFrame();
        delBtn2 = new JButton();
        cancelBtn2 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        nameLabel = new JLabel();
        addBtn = new JButton();
        saveBtn = new JButton();

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
                    table1.setSelectionForeground(new Color(242, 242, 242));
                    table1.setBackground(new Color(242, 242, 242));
                    table1.setGridColor(new Color(242, 242, 242));
                    scrollPane1.setViewportView(table1);
                }

                //---- viewBtn ----
                viewBtn.setText(bundle.getString("viewBtn.text"));
                viewBtn.addActionListener(e -> viewBtnActionPerformed(e));

                //---- delBTn ----
                delBTn.setText(bundle.getString("delBTn.text"));
                delBTn.addActionListener(e -> delBTnActionPerformed(e));

                //---- newBtn ----
                newBtn.setText(bundle.getString("newBtn.text"));
                newBtn.addActionListener(e -> newBtnActionPerformed(e));

                //---- selCB ----
                selCB.addActionListener(e -> selComboBoxActionPerformed(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(viewBtn)
                            .addGap(40, 40, 40)
                            .addComponent(delBTn)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newBtn, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(selCB, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(selCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(newBtn)
                                .addComponent(viewBtn)
                                .addComponent(delBTn))
                            .addGap(25, 25, 25)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- saveButton ----
                saveButton.setText(bundle.getString("saveButton.text"));
                saveButton.addActionListener(e -> saveButtonActionPerformed(e));

                //---- cancelButton ----
                cancelButton.setText(bundle.getString("cancelButton.text"));
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                            .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(142, 142, 142))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelButton)
                                .addComponent(saveButton))
                            .addContainerGap())
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //======== frame1 ========
        {
            frame1.setResizable(false);
            var frame1ContentPane = frame1.getContentPane();

            //---- delBtn2 ----
            delBtn2.setText(bundle.getString("delBtn2.text"));
            delBtn2.addActionListener(e -> delBtn2ActionPerformed(e));

            //---- cancelBtn2 ----
            cancelBtn2.setText(bundle.getString("cancelBtn2.text"));
            cancelBtn2.addActionListener(e -> cancelBtn2ActionPerformed(e));

            //======== scrollPane2 ========
            {

                //---- table2 ----
                table2.setBackground(new Color(242, 242, 242));
                table2.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        " ", "ID", "\u9898\u76ee"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Boolean.class, Integer.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                scrollPane2.setViewportView(table2);
            }

            //---- addBtn ----
            addBtn.setText(bundle.getString("addBtn.text"));
            addBtn.addActionListener(e -> addBtnActionPerformed(e));

            //---- saveBtn ----
            saveBtn.setText(bundle.getString("saveBtn.text"));
            saveBtn.addActionListener(e -> saveBtnActionPerformed(e));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(saveBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(cancelBtn2)
                        .addGap(77, 77, 77))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addComponent(delBtn2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(addBtn)))
                        .addContainerGap())
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                                .addContainerGap(43, Short.MAX_VALUE)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(addBtn)
                                    .addComponent(delBtn2))
                                .addGap(18, 18, 18)))
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelBtn2)
                            .addComponent(saveBtn)))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton viewBtn;
    private JButton delBTn;
    private JButton newBtn;
    private JComboBox selCB;
    private JPanel buttonBar;
    private JButton saveButton;
    private JButton cancelButton;
    private JFrame frame1;
    private JButton delBtn2;
    private JButton cancelBtn2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel nameLabel;
    private JButton addBtn;
    private JButton saveBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

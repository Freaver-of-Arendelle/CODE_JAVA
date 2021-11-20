/*
 * Created by JFormDesigner on Wed Jul 14 14:33:35 CST 2021
 */

package view;

import cn.hutool.core.date.DateUtil;
import controller.PatientController;
import model.bean.Patient;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Freaver
 */
public class PatientUI extends JFrame {

    private class JTableEmbedButton extends AbstractCellEditor implements
            TableCellEditor, TableCellRenderer {

        JButton jb;

        public JTableEmbedButton(String title) {
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            Vector<Vector> dataVector = model.getDataVector();

//            Vector<Patient> patientVector = new Vector<>();
//            for (Vector vector : dataVector) {
//                if (vector.get(0).equals(true)) {
//                    patientVector.add(new Patient(((String) vector.get(1)), null, ((String) vector.get(3)), null, null,null
//                    ,null));
//                }
//            }

            jb = new JButton(title);

            jb.addActionListener(e -> {
                Vector<Patient> patientVector = new Vector<>();
                for (Vector vector : dataVector) {
                    if (vector.get(0).equals(true)) {
                        patientVector.add(new Patient(((String) vector.get(1)), null, ((String) vector.get(3)), null, null, null
                                , null));
                    }
                }
                new EstimatorUI(patientVector, username).setVisible(true);
            });

//            jb.addActionListener(arg0 -> new EstimatorUI(patientVector).setVisible(true));
        }

        @Override
        public Object getCellEditorValue() {
            return jb;
        }

        @Override
        public Component getTableCellRendererComponent(JTable arg0, Object arg1,
                                                       boolean arg2, boolean arg3, int arg4, int arg5) {
            return jb;
        }

        @Override
        public Component getTableCellEditorComponent(JTable arg0, Object arg1,
                                                     boolean arg2, int arg3, int arg4) {
            return jb;
        }

    }


    private String username = null;
//    private static String name;
//    private static Date birthday;
//    private static String gender;
//    private static String id;
//    private static String tel;
//    private static String emergencyContact;
//    private static String emergencyTel;

    private static PatientController controller = PatientController.getSingleton();
    private static Set<Patient> set = controller.getPatients();

    /**
     * 根据提供的vector来初始化model
     *
     * @param model
     * @param vector
     */
    public static void init(DefaultTableModel model, Vector<Patient> vector) {
        int size = vector.size();

        for (int i = 0; i < size; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(false);
            vector1.add(vector.get(i).getName());
            vector1.add(vector.get(i).getBirthday());
            vector1.add(vector.get(i).getGender());
            vector1.add(vector.get(i).getId());
            vector1.add(vector.get(i).getTel());
            vector1.add(vector.get(i).getEmergencyContact());
            vector1.add(vector.get(i).getEmergencyTel());
            model.addRow(vector1);
        }
    }

    /**
     * 根据提供的model和vector来调用init方法并且重绘
     *
     * @param model
     * @param vector
     */
    private void refresh(DefaultTableModel model, Vector<Patient> vector) {
        model.getDataVector().clear();
        init(model, vector);
        table1.setModel(model);
        table1.repaint();
    }

    public PatientUI() {
        initComponents();
        TableColumn tc = table1.getColumnModel().getColumn(8);
        tc.setCellEditor(table1.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table1.getDefaultRenderer(Boolean.class));
        tc.setCellEditor(new JTableEmbedButton("评估"));
        tc.setCellRenderer(new JTableEmbedButton("评估"));
        refresh(((DefaultTableModel) table1.getModel()), new Vector<>(set));
    }

    public PatientUI(String username) {
        this.username = username;
        initComponents();
        TableColumn tc = table1.getColumnModel().getColumn(8);
        tc.setCellEditor(table1.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table1.getDefaultRenderer(Boolean.class));
        tc.setCellEditor(new JTableEmbedButton("评估"));
        tc.setCellRenderer(new JTableEmbedButton("评估"));
        refresh(((DefaultTableModel) table1.getModel()), new Vector<>(set));
    }

    public static void main(String[] args) {
        PatientUI ui = new PatientUI();
        ui.setVisible(true);
    }

    private void delBtnActionPerformed(ActionEvent e) {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        for (int i = 0; i < table1.getRowCount(); i++) {
            if (table1.getValueAt(i, 0).equals(true)) {
                String tempName = (String) table1.getValueAt(i, 1);
                set.removeIf((c -> c.getName().equals(tempName)));
            }
        }
        refresh(model, new Vector<>(set));
    }

    private void addBtnActionPerformed(ActionEvent e) {
        original(nameField3, birFiled3, genderField3, idField3, telField3, emeFiled3, emeTelField3, frame3);
    }

    private void original(JTextField nameField3, JTextField birFiled3, JTextField genderField3, JTextField idField3, JTextField telField3, JTextField emeFiled3, JTextField emeTelField3, JFrame frame3) {
        nameField3.setText("");
        birFiled3.setText("");
        genderField3.setText("");
        idField3.setText("");
        telField3.setText("");
        emeFiled3.setText("");
        emeTelField3.setText("");
        frame3.setVisible(true);
    }

    private void temBtnActionPerformed(ActionEvent e) {
        new TemplateListUI().setVisible(true);
    }

    private void modifyBtnActionPerformed(ActionEvent e) {
        original(nameField2, birFiled2, genderField2, idField2, telField2, emeFiled2, emeTelField2, frame2);

    }

    private void saveBtnActionPerformed(ActionEvent e) {
        controller.clear();
        for (Patient patient : set) {
            controller.addPatient(patient);
        }
        this.dispose();
    }

    private void returnBtnActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void searchBtnActionPerformed(ActionEvent e) {

        String name = nameField.getText();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        if (!name.equals("")) {
            Set<Patient> patientSet = new HashSet<>(set);
            patientSet.removeIf(c -> !c.getName().equals(name));
            refresh(model, new Vector<>(patientSet));
        } else {
            refresh(model, new Vector<>(set));
        }
    }

    private void saveBtn2ActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        for (int i = 0; i < table1.getRowCount(); i++) {
            if (table1.getValueAt(i, 0).equals(true)) {
                String tempName = (String) table1.getValueAt(i, 1);
                set.removeIf((c -> c.getName().equals(tempName)));
            }
        }
        set.add(new Patient(nameField2.getText(), DateUtil.parse(birFiled2.getText()), genderField2.getText(),
                idField2.getText(), telField2.getText(), emeFiled2.getText(), emeTelField2.getText()));
        refresh(model, new Vector<>(set));
        frame2.dispose();
    }

    private void returnBtn2ActionPerformed(ActionEvent e) {
        frame2.dispose();
    }

    private void saveBtn3ActionPerformed(ActionEvent e) {
        set.add(new Patient(nameField3.getText(), DateUtil.parse(birFiled3.getText()), genderField3.getText(),
                idField3.getText(), telField3.getText(), emeFiled3.getText(), emeTelField3.getText()));
        refresh(((DefaultTableModel) table1.getModel()), new Vector<>(set));
        frame3.dispose();
    }

    private void returnBtn3ActionPerformed(ActionEvent e) {
        frame3.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("patient");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        searchBtn = new JButton();
        nameField = new JTextField();
        delBtn = new JButton();
        addBtn = new JButton();
        temBtn = new JButton();
        modifyBtn = new JButton();
        buttonBar = new JPanel();
        saveBtn = new JButton();
        returnBtn = new JButton();
        frame2 = new JFrame();
        dialogPane2 = new JPanel();
        contentPanel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        nameField2 = new JTextField();
        birFiled2 = new JTextField();
        idField2 = new JTextField();
        telField2 = new JTextField();
        emeFiled2 = new JTextField();
        emeTelField2 = new JTextField();
        label7 = new JLabel();
        genderField2 = new JTextField();
        buttonBar2 = new JPanel();
        saveBtn2 = new JButton();
        returnBtn2 = new JButton();
        frame3 = new JFrame();
        dialogPane3 = new JPanel();
        contentPanel3 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        nameField3 = new JTextField();
        birFiled3 = new JTextField();
        idField3 = new JTextField();
        telField3 = new JTextField();
        emeFiled3 = new JTextField();
        emeTelField3 = new JTextField();
        label14 = new JLabel();
        genderField3 = new JTextField();
        buttonBar3 = new JPanel();
        saveBtn3 = new JButton();
        returnBtn3 = new JButton();

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
                            " ", "\u59d3\u540d", "\u51fa\u751f\u65e5\u671f", "\u6027\u522b", "\u8eab\u4efd\u8bc1\u53f7", "\u8054\u7cfb\u7535\u8bdd", "\u7d27\u6025\u8054\u7cfb\u4eba", "\u7d27\u6025\u8054\u7cfb\u4eba\u7535\u8bdd", null
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Boolean.class, String.class, Date.class, String.class, String.class, String.class, String.class, String.class, Object.class
                        };
                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }
                    });
                    table1.setGridColor(new Color(242, 242, 242));
                    table1.setSelectionForeground(new Color(242, 242, 242));
                    table1.setBackground(new Color(242, 242, 242));
                    scrollPane1.setViewportView(table1);
                }

                //---- searchBtn ----
                searchBtn.setText(bundle.getString("searchBtn.text"));
                searchBtn.addActionListener(e -> searchBtnActionPerformed(e));

                //---- delBtn ----
                delBtn.setText(bundle.getString("delBtn.text"));
                delBtn.addActionListener(e -> delBtnActionPerformed(e));

                //---- addBtn ----
                addBtn.setText(bundle.getString("addBtn.text"));
                addBtn.addActionListener(e -> addBtnActionPerformed(e));

                //---- temBtn ----
                temBtn.setText(bundle.getString("temBtn.text"));
                temBtn.addActionListener(e -> temBtnActionPerformed(e));

                //---- modifyBtn ----
                modifyBtn.setText(bundle.getString("modifyBtn.text"));
                modifyBtn.addActionListener(e -> modifyBtnActionPerformed(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(delBtn)))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchBtn)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
                                    .addComponent(temBtn)
                                    .addGap(18, 18, 18)))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(addBtn))
                                .addComponent(modifyBtn))
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchBtn)
                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addContainerGap(39, Short.MAX_VALUE)
                                    .addComponent(modifyBtn)))
                            .addGap(8, 8, 8)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addBtn)
                                .addComponent(temBtn)
                                .addComponent(delBtn))
                            .addGap(12, 12, 12)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- saveBtn ----
                saveBtn.setText(bundle.getString("saveBtn.text"));
                saveBtn.addActionListener(e -> saveBtnActionPerformed(e));

                //---- returnBtn ----
                returnBtn.setText(bundle.getString("returnBtn.text"));
                returnBtn.addActionListener(e -> returnBtnActionPerformed(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGap(122, 122, 122)
                            .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                            .addComponent(returnBtn, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                            .addGap(125, 125, 125))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(returnBtn)
                            .addComponent(saveBtn))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //======== frame2 ========
        {
            frame2.setResizable(false);
            var frame2ContentPane = frame2.getContentPane();
            frame2ContentPane.setLayout(new BorderLayout());

            //======== dialogPane2 ========
            {
                dialogPane2.setBorder(new EmptyBorder(12, 12, 12, 12));
                dialogPane2.setLayout(new BorderLayout());

                //======== contentPanel2 ========
                {

                    //---- label1 ----
                    label1.setText(bundle.getString("label1.text"));
                    label1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label2 ----
                    label2.setText(bundle.getString("label2.text"));
                    label2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label3 ----
                    label3.setText(bundle.getString("label3.text"));
                    label3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label4 ----
                    label4.setText(bundle.getString("label4.text"));
                    label4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label5 ----
                    label5.setText(bundle.getString("label5.text"));
                    label5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label6 ----
                    label6.setText(bundle.getString("label6.text"));
                    label6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label7 ----
                    label7.setText(bundle.getString("label7.text"));
                    label7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    GroupLayout contentPanel2Layout = new GroupLayout(contentPanel2);
                    contentPanel2.setLayout(contentPanel2Layout);
                    contentPanel2Layout.setHorizontalGroup(
                        contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, contentPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(label7, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                        .addGap(0, 7, Short.MAX_VALUE)
                                        .addGroup(contentPanel2Layout.createParallelGroup()
                                            .addComponent(label3, GroupLayout.Alignment.TRAILING)
                                            .addComponent(label4, GroupLayout.Alignment.TRAILING)
                                            .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label5, GroupLayout.Alignment.TRAILING)
                                            .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(idField2, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(telField2, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(birFiled2)
                                    .addComponent(genderField2, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(nameField2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(emeFiled2, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(emeTelField2, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                .addGap(169, 169, 169))
                    );
                    contentPanel2Layout.setVerticalGroup(
                        contentPanel2Layout.createParallelGroup()
                            .addGroup(contentPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameField2, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addGroup(contentPanel2Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(birFiled2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(genderField2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(idField2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(telField2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emeFiled2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emeTelField2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
                    );
                }
                dialogPane2.add(contentPanel2, BorderLayout.CENTER);

                //======== buttonBar2 ========
                {
                    buttonBar2.setBorder(new EmptyBorder(12, 0, 0, 0));

                    //---- saveBtn2 ----
                    saveBtn2.setText(bundle.getString("saveBtn2.text"));
                    saveBtn2.addActionListener(e -> saveBtn2ActionPerformed(e));

                    //---- returnBtn2 ----
                    returnBtn2.setText(bundle.getString("returnBtn2.text"));
                    returnBtn2.addActionListener(e -> returnBtn2ActionPerformed(e));

                    GroupLayout buttonBar2Layout = new GroupLayout(buttonBar2);
                    buttonBar2.setLayout(buttonBar2Layout);
                    buttonBar2Layout.setHorizontalGroup(
                        buttonBar2Layout.createParallelGroup()
                            .addGroup(buttonBar2Layout.createSequentialGroup()
                                .addContainerGap(75, Short.MAX_VALUE)
                                .addComponent(saveBtn2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(returnBtn2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))
                    );
                    buttonBar2Layout.setVerticalGroup(
                        buttonBar2Layout.createParallelGroup()
                            .addGroup(buttonBar2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(saveBtn2)
                                .addComponent(returnBtn2))
                    );
                }
                dialogPane2.add(buttonBar2, BorderLayout.SOUTH);
            }
            frame2ContentPane.add(dialogPane2, BorderLayout.CENTER);
            frame2.pack();
            frame2.setLocationRelativeTo(frame2.getOwner());
        }

        //======== frame3 ========
        {
            frame3.setResizable(false);
            var frame3ContentPane = frame3.getContentPane();
            frame3ContentPane.setLayout(new BorderLayout());

            //======== dialogPane3 ========
            {
                dialogPane3.setBorder(new EmptyBorder(12, 12, 12, 12));
                dialogPane3.setLayout(new BorderLayout());

                //======== contentPanel3 ========
                {

                    //---- label8 ----
                    label8.setText(bundle.getString("label8.text"));
                    label8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label9 ----
                    label9.setText(bundle.getString("label9.text"));
                    label9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label10 ----
                    label10.setText(bundle.getString("label10.text"));
                    label10.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label11 ----
                    label11.setText(bundle.getString("label11.text"));
                    label11.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label12 ----
                    label12.setText(bundle.getString("label12.text"));
                    label12.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label13 ----
                    label13.setText(bundle.getString("label13.text"));
                    label13.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- label14 ----
                    label14.setText(bundle.getString("label14.text"));
                    label14.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    GroupLayout contentPanel3Layout = new GroupLayout(contentPanel3);
                    contentPanel3.setLayout(contentPanel3Layout);
                    contentPanel3Layout.setHorizontalGroup(
                        contentPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, contentPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPanel3Layout.createParallelGroup()
                                    .addComponent(label14, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label9, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(label8, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(label10, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(label11, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(label12, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(label13, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel3Layout.createParallelGroup()
                                    .addComponent(idField3, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(telField3, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(birFiled3)
                                    .addComponent(genderField3, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(nameField3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(emeFiled3, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(emeTelField3, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                .addGap(169, 169, 169))
                    );
                    contentPanel3Layout.setVerticalGroup(
                        contentPanel3Layout.createParallelGroup()
                            .addGroup(contentPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(contentPanel3Layout.createParallelGroup()
                                    .addComponent(nameField3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 8, Short.MAX_VALUE)
                                .addGroup(contentPanel3Layout.createParallelGroup()
                                    .addComponent(birFiled3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label9, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel3Layout.createParallelGroup()
                                    .addComponent(genderField3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label14, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(contentPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(idField3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanel3Layout.createParallelGroup()
                                    .addComponent(telField3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label11, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(emeFiled3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(emeTelField3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label13, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(45, Short.MAX_VALUE))
                    );
                }
                dialogPane3.add(contentPanel3, BorderLayout.CENTER);

                //======== buttonBar3 ========
                {
                    buttonBar3.setBorder(new EmptyBorder(12, 0, 0, 0));

                    //---- saveBtn3 ----
                    saveBtn3.setText(bundle.getString("saveBtn3.text"));
                    saveBtn3.addActionListener(e -> saveBtn3ActionPerformed(e));

                    //---- returnBtn3 ----
                    returnBtn3.setText(bundle.getString("returnBtn3.text"));
                    returnBtn3.addActionListener(e -> returnBtn3ActionPerformed(e));

                    GroupLayout buttonBar3Layout = new GroupLayout(buttonBar3);
                    buttonBar3.setLayout(buttonBar3Layout);
                    buttonBar3Layout.setHorizontalGroup(
                        buttonBar3Layout.createParallelGroup()
                            .addGroup(buttonBar3Layout.createSequentialGroup()
                                .addContainerGap(75, Short.MAX_VALUE)
                                .addComponent(saveBtn3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(returnBtn3, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96))
                    );
                    buttonBar3Layout.setVerticalGroup(
                        buttonBar3Layout.createParallelGroup()
                            .addGroup(buttonBar3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(saveBtn3)
                                .addComponent(returnBtn3))
                    );
                }
                dialogPane3.add(buttonBar3, BorderLayout.SOUTH);
            }
            frame3ContentPane.add(dialogPane3, BorderLayout.CENTER);
            frame3.pack();
            frame3.setLocationRelativeTo(frame3.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton searchBtn;
    private JTextField nameField;
    private JButton delBtn;
    private JButton addBtn;
    private JButton temBtn;
    private JButton modifyBtn;
    private JPanel buttonBar;
    private JButton saveBtn;
    private JButton returnBtn;
    private JFrame frame2;
    private JPanel dialogPane2;
    private JPanel contentPanel2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField nameField2;
    private JTextField birFiled2;
    private JTextField idField2;
    private JTextField telField2;
    private JTextField emeFiled2;
    private JTextField emeTelField2;
    private JLabel label7;
    private JTextField genderField2;
    private JPanel buttonBar2;
    private JButton saveBtn2;
    private JButton returnBtn2;
    private JFrame frame3;
    private JPanel dialogPane3;
    private JPanel contentPanel3;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JTextField nameField3;
    private JTextField birFiled3;
    private JTextField idField3;
    private JTextField telField3;
    private JTextField emeFiled3;
    private JTextField emeTelField3;
    private JLabel label14;
    private JTextField genderField3;
    private JPanel buttonBar3;
    private JButton saveBtn3;
    private JButton returnBtn3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Wed Jul 14 09:33:30 CST 2021
 */

package view;

import controller.StaffController;
import controller.UserSecureController;
import model.bean.Staff;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.*;

/**
 * @author Freaver
 */
public class AdministratorUI extends JFrame {
    private static StaffController controller = StaffController.getSingleton();

    private static Set<Staff> set = controller.getStaffs();

    private static String username;
    private static String name;
    private static String password;
    private static boolean nameIsMatch;
    private static boolean passIsMatch;

    /**
     * 根据提供的vector来初始化model
     *
     * @param model
     * @param vector
     */
    private static void init(DefaultTableModel model, Vector<Staff> vector) {
        int size = vector.size();
//        if (size > 0) {
        for (int i = 0; i < size; i++) {
            Vector<Object> vector1 = new Vector<>();
            vector1.add(false);
            vector1.add(vector.get(i).getUsername());
            vector1.add(vector.get(i).getName());
            vector1.add(vector.get(i).getBirthday());
            vector1.add(vector.get(i).getSpecialty());
            vector1.add(vector.get(i).getJobTitle());
            vector1.add(vector.get(i).getTel());
            model.addRow(vector1);
        }
    }

    /**
     * 根据提供的model和vector来调用init方法并且重绘
     *
     * @param model
     * @param vector
     */
    private void refresh(DefaultTableModel model, Vector<Staff> vector) {
        model.getDataVector().clear();
        init(model, vector);
        table1.setModel(model);
        table1.repaint();
//        scrollPane1.repaint();
    }

    public AdministratorUI() {

        initComponents();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        refresh(model, new Vector<>(set));
        selInit(selCB, set);
    }


    public static void main(String[] args) {
        AdministratorUI ui = new AdministratorUI();
        ui.setVisible(true);
    }

    /**
     * 根据提供的set对JComboBox进行初始化
     *
     * @param selCB
     * @param set
     */
    private static void selInit(JComboBox selCB, Set<Staff> set) {
        Set<String> stringSet = new HashSet<>();
        selCB.removeAllItems();
        stringSet.add("请选择职称");
        for (Staff staff : set) {
            stringSet.add(staff.getJobTitle());
        }

        for (String s : stringSet) {
            selCB.addItem(s);
        }
    }

    private void searchBtnActionPerformed(ActionEvent e) {
//        获取搜索框中输入的名字
        String name = nameField.getText();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
//        对获取到的文字进行判断，如果为空则显示全部，否则显示指定的数据
        if (!name.equals("")) {
            Set<Staff> staffSet = new HashSet<>(set);
            staffSet.removeIf(c -> !c.getName().equals(name));
            refresh(model, new Vector<>(staffSet));
        } else {
            refresh(model, new Vector<>(set));
        }

    }

    private void selCBActionPerformed(ActionEvent e) {

//        获取选择列表里的数据
        String jobTitle = (String) selCB.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

//        对获取到的信息进行判断，如果不是初始值则显示全部，否则显示指定数据
        if (!"请选择职称".equals(jobTitle)) {
            Vector<Staff> staffVector = new Vector<>(set);
            staffVector.removeIf(c -> !c.getJobTitle().equals(jobTitle));
            refresh(model, staffVector);
        } else {
            refresh(model, new Vector<>(set));

        }
    }

    private void deleteBtnActionPerformed(ActionEvent e) {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        for (int i = 0; i < table1.getRowCount(); i++) {
            if (table1.getValueAt(i, 0).equals(true)) {
                String tempName = (String) table1.getValueAt(i, 1);
                set.removeIf((c -> c.getUsername().equals(tempName)));
            }
        }

        selInit(selCB, set);
        refresh(model, new Vector<>(set));
    }


    private void addBtnActionPerformed(ActionEvent e) {
        frame2.setVisible(true);
    }

    private void saveBtnActionPerformed(ActionEvent e) {

        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        Vector<Vector> dataVector = model.getDataVector();
        controller.clear();
        for (Vector vector1 : dataVector) {
            controller.addStaff(new Staff(((String) vector1.get(1)),
                    ((String) vector1.get(2)),
                    ((Date) vector1.get(3)),
                    ((String) vector1.get(4)),
                    ((String) vector1.get(5)),
                    ((String) vector1.get(6))));
        }
//        controller.clear();
//        for (Staff staff : set) {
//            controller.addStaff(staff);
//        }
        this.dispose();
    }

    private void returnBtnActionPerformed(ActionEvent e) {
//        System.exit(0);
        this.dispose();
    }

    private void subButtonActionPerformed(ActionEvent e) {
        if (nameIsMatch && passIsMatch) {
            username = userField.getText();
            UserSecureController.getSingleton().addUser(name, password, false);
            set.add(new Staff(username, null, null, null, null, null));
            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            refresh(model, new Vector<>(set));
            JOptionPane.showMessageDialog(frame2, "注册成功");
            frame2.dispose();
        }
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        frame2.dispose();
//        System.exit(0);
    }


    private void userFieldFocusLost(FocusEvent e) {
        String pattern = "^\\w{6,12}$";
        username = userField.getText();
        nameIsMatch = username.matches(pattern);


        if (nameIsMatch) {
            name = username;
            userLabel.setText("");
        } else {
            userLabel.setText("用户名格式不正确");
        }

        for (Staff staff : set) {
            if (staff.getUsername().equals(username)) {
                userLabel.setText("该用户已存在");
                nameIsMatch = false;
            }
        }
    }

    private void passwordFieldFocusLost(FocusEvent e) {
        String pattern = "^\\w{8,15}$";
        String tempPassword = String.valueOf(passwordField.getPassword());
        passIsMatch = tempPassword.matches(pattern);

        if (passIsMatch) {
            password = tempPassword;
            pwLabel.setText("");
        } else {
            pwLabel.setText("密码格式不正确");
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("administrator");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        nameField = new JTextField();
        searchBtn = new JButton();
        selCB = new JComboBox();
        deleteBtn = new JButton();
        addBtn = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        buttonBar = new JPanel();
        saveBtn = new JButton();
        returnBtn = new JButton();
        frame2 = new JFrame();
        dialogPane2 = new JPanel();
        contentPanel2 = new JPanel();
        userLabel1 = new JLabel();
        userField = new JTextField();
        label1 = new JLabel();
        userLabel = new JLabel();
        label2 = new JLabel();
        passwordField = new JPasswordField();
        label3 = new JLabel();
        pwLabel = new JLabel();
        buttonBar2 = new JPanel();
        subButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setResizable(false);
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- searchBtn ----
                searchBtn.setText(bundle.getString("searchBtn.text_2"));
                searchBtn.addActionListener(e -> searchBtnActionPerformed(e));

                //---- selCB ----
                selCB.addActionListener(e -> selCBActionPerformed(e));

                //---- deleteBtn ----
                deleteBtn.setText(bundle.getString("deleteBtn.text_2"));
                deleteBtn.addActionListener(e -> deleteBtnActionPerformed(e));

                //---- addBtn ----
                addBtn.setText(bundle.getString("addBtn.text_2"));
                addBtn.addActionListener(e -> addBtnActionPerformed(e));

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            " ", "\u7528\u6237\u540d", "\u59d3\u540d", "\u51fa\u751f\u65e5\u671f", "\u4e13\u957f", "\u804c\u79f0", "\u8054\u7cfb\u7535\u8bdd"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            Boolean.class, String.class, String.class, Date.class, String.class, String.class, String.class
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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(searchBtn)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(selCB, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                            .addGap(646, 646, 646))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 823, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(deleteBtn, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addGap(23, 23, 23))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(searchBtn)
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(selCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteBtn)
                                .addComponent(addBtn))
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- saveBtn ----
                saveBtn.setText(bundle.getString("saveBtn.text_2"));
                saveBtn.addActionListener(e -> saveBtnActionPerformed(e));

                //---- returnBtn ----
                returnBtn.setText(bundle.getString("returnBtn.text_2"));
                returnBtn.addActionListener(e -> returnBtnActionPerformed(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 567, Short.MAX_VALUE)
                            .addComponent(returnBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(saveBtn)
                            .addComponent(returnBtn))
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

                    //---- userLabel1 ----
                    userLabel1.setText(bundle.getString("userLabel1.text_2"));
                    userLabel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- userField ----
                    userField.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                            userFieldFocusLost(e);
                        }
                    });

                    //---- label1 ----
                    label1.setText(bundle.getString("label1.text"));
                    label1.setForeground(Color.red);

                    //---- userLabel ----
                    userLabel.setForeground(Color.red);

                    //---- label2 ----
                    label2.setText(bundle.getString("label2.text"));
                    label2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

                    //---- passwordField ----
                    passwordField.addFocusListener(new FocusAdapter() {
                        @Override
                        public void focusLost(FocusEvent e) {
                            passwordFieldFocusLost(e);
                        }
                    });

                    //---- label3 ----
                    label3.setText(bundle.getString("label3.text"));
                    label3.setForeground(Color.red);

                    //---- pwLabel ----
                    pwLabel.setForeground(Color.red);

                    GroupLayout contentPanel2Layout = new GroupLayout(contentPanel2);
                    contentPanel2.setLayout(contentPanel2Layout);
                    contentPanel2Layout.setHorizontalGroup(
                        contentPanel2Layout.createParallelGroup()
                            .addGroup(contentPanel2Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userLabel1, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(userField, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(userLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(contentPanel2Layout.createSequentialGroup()
                                        .addComponent(pwLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                .addContainerGap(202, Short.MAX_VALUE)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                        .addGap(190, 190, 190))
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addGap(205, 205, 205))))
                    );
                    contentPanel2Layout.setVerticalGroup(
                        contentPanel2Layout.createParallelGroup()
                            .addGroup(contentPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(userField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addComponent(label3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pwLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105))
                    );
                }
                dialogPane2.add(contentPanel2, BorderLayout.NORTH);

                //======== buttonBar2 ========
                {
                    buttonBar2.setBorder(new EmptyBorder(12, 0, 0, 0));

                    //---- subButton ----
                    subButton.setText(bundle.getString("subButton.text"));
                    subButton.addActionListener(e -> subButtonActionPerformed(e));

                    //---- cancelButton ----
                    cancelButton.setText(bundle.getString("cancelButton.text_3"));
                    cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));

                    GroupLayout buttonBar2Layout = new GroupLayout(buttonBar2);
                    buttonBar2.setLayout(buttonBar2Layout);
                    buttonBar2Layout.setHorizontalGroup(
                        buttonBar2Layout.createParallelGroup()
                            .addGroup(buttonBar2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(subButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93))
                    );
                    buttonBar2Layout.setVerticalGroup(
                        buttonBar2Layout.createParallelGroup()
                            .addGroup(buttonBar2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelButton)
                                .addComponent(subButton))
                    );
                }
                dialogPane2.add(buttonBar2, BorderLayout.SOUTH);
            }
            frame2ContentPane.add(dialogPane2, BorderLayout.CENTER);
            frame2.pack();
            frame2.setLocationRelativeTo(frame2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField nameField;
    private JButton searchBtn;
    private JComboBox selCB;
    private JButton deleteBtn;
    private JButton addBtn;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel buttonBar;
    private JButton saveBtn;
    private JButton returnBtn;
    private JFrame frame2;
    private JPanel dialogPane2;
    private JPanel contentPanel2;
    private JLabel userLabel1;
    private JTextField userField;
    private JLabel label1;
    private JLabel userLabel;
    private JLabel label2;
    private JPasswordField passwordField;
    private JLabel label3;
    private JLabel pwLabel;
    private JPanel buttonBar2;
    private JButton subButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

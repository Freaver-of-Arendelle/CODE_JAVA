/*
 * Created by JFormDesigner on Wed Jul 14 09:05:03 CST 2021
 */

package view;

import controller.UserSecureController;
import model.bean.User;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Freaver
 */
public class LoginUI extends JFrame {
    public LoginUI() {
        initComponents();
    }

    private static String name;
    private static String password;

    private static boolean nameIsMatch = false;
    private static boolean passwordIsMatch = false;

    private static boolean isAdministrator = false;

//    private Set<User> set = new HashSet<>();

//    public void setSet(Set<User> set) {
//
//
//    }

    private static UserSecureController controller;

    public static void main(String[] args) {
        new LoginUI().setVisible(true);
    }

    private void userFieldFocusLost(FocusEvent e) {
        String pattern = "^\\w{6,12}$";
        nameIsMatch = userField.getText().matches(pattern);

        if (nameIsMatch) {
            name = userField.getText();
            userLabel.setText("");
        } else {
            userLabel.setText("用户名格式不正确");
        }
    }

    private void passwordFieldFocusLost(FocusEvent e) {
        String pattern = "^\\w{8,15}$";

        passwordIsMatch = String.valueOf(passwordField.getPassword()).matches(pattern);

        if (passwordIsMatch) {
            password = String.valueOf(passwordField.getPassword());
            passwordLabel.setText("");
        } else {
            passwordLabel.setText("密码格式不正确");
        }
    }

    private void adminBtnActionPerformed(ActionEvent e) {
        isAdministrator = true;

    }

    private void userBtnActionPerformed(ActionEvent e) {
        isAdministrator = false;
    }

    private void saveButtonActionPerformed(ActionEvent e) {

        if (passwordIsMatch && nameIsMatch) {
            controller = UserSecureController.getSingleton();
            Set<User> set = controller.getUsers();


            for (User user : set) {
                if (user.getUserName().equals(name) &&
                    user.getPassword().equals(password) &&
                        user.getIsAdministrator().equals(isAdministrator)) {
                    JOptionPane.showMessageDialog(this, "登陆成功");
                    this.dispose();
                    if (isAdministrator) {
                        new AdministratorUI().setVisible(true);
                    } else {
                        new PatientUI(user.getUserName()).setVisible(true);
                    }
                }
            }
            controller.addUser(name, password, isAdministrator);

        }
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("login");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        adminBtn = new JRadioButton();
        userBtn = new JRadioButton();
        label1 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        userField = new JTextField();
        passwordField = new JPasswordField();
        userLabel = new JLabel();
        passwordLabel = new JLabel();
        buttonBar = new JPanel();
        saveButton = new JButton();
        cancelButton = new JButton();

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

                //---- adminBtn ----
                adminBtn.setText(bundle.getString("adminBtn.text"));
                adminBtn.addActionListener(e -> adminBtnActionPerformed(e));

                //---- userBtn ----
                userBtn.setText(bundle.getString("userBtn.text"));
                userBtn.setSelected(true);
                userBtn.addActionListener(e -> userBtnActionPerformed(e));

                //---- label1 ----
                label1.setText(bundle.getString("label1.text_2"));

                //---- label4 ----
                label4.setText(bundle.getString("label4.text_2"));

                //---- label5 ----
                label5.setText(bundle.getString("label5.text_2"));

                //---- label2 ----
                label2.setText(bundle.getString("label2.text_2"));

                //---- label3 ----
                label3.setText(bundle.getString("label3.text_2"));

                //---- userField ----
                userField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        userFieldFocusLost(e);
                    }
                });

                //---- passwordField ----
                passwordField.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        passwordFieldFocusLost(e);
                    }
                });

                //---- userLabel ----
                userLabel.setForeground(Color.red);

                //---- passwordLabel ----
                passwordLabel.setForeground(Color.red);

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(89, 89, 89)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(userField, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addGap(109, 109, 109)
                                            .addComponent(label1)
                                            .addGap(18, 18, 18)
                                            .addComponent(adminBtn)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(userBtn)
                                            .addGap(18, 18, 18)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(userLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(189, 189, 189)
                                    .addComponent(label5)
                                    .addGap(0, 193, Short.MAX_VALUE)))
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(0, 177, Short.MAX_VALUE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                            .addGap(156, 156, 156))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(adminBtn)
                                .addComponent(userBtn)
                                .addComponent(label1))
                            .addGap(24, 24, 24)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(96, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);

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
                            .addGap(76, 76, 76)
                            .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                            .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelButton)
                                .addComponent(saveButton))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(adminBtn);
        buttonGroup1.add(userBtn);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JRadioButton adminBtn;
    private JRadioButton userBtn;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label2;
    private JLabel label3;
    private JTextField userField;
    private JPasswordField passwordField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JPanel buttonBar;
    private JButton saveButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

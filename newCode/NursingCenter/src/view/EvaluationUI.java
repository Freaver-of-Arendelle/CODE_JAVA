/*
 * Created by JFormDesigner on Fri Jul 16 11:19:28 CST 2021
 */

package view;

import model.bean.Problem;
import model.bean.Template;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author Freaver
 */
public class EvaluationUI extends JFrame {
    public EvaluationUI() {
        initComponents();
    }

    private ButtonGroup[] buttonGroups;

    private Set<Problem> problems;

    private List<Problem> list;

    private JPanel jPanel = new JPanel();


    /**
     * 根据上一级传递的template来绘制JScrollPane所需的组件
     * @param template
     */
    public EvaluationUI(Template template) {
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        problems = template.getProblems();
        list = new ArrayList<>(problems);
        buttonGroups = new ButtonGroup[problems.size()];
        initComponents();
        int i = 0;
        JLabel[] js = new JLabel[problems.size()];
        for (Problem problem : list) {

            String[] answers = problem.getAnswers();
            buttonGroups[i] = new ButtonGroup();
            js[i] = new JLabel(problem.getQuestion());
            js[i].setBounds(0, 30 * (i + 1), 150, 50);
            jPanel.add(js[i]);

            JRadioButton[] jRadioButtons = new JRadioButton[3];
            init(i, answers[0], jRadioButtons[0], 60);
            init(i, answers[1], jRadioButtons[1], 90);
            init(i, answers[2], jRadioButtons[2], 120);
            i++;
        }
        scrollPane1.setViewportView(jPanel);
        pack();
        this.setSize(400, 415);
    }

    private void init(int i, String answer, JRadioButton jRadioButton, int y) {
        jRadioButton = new JRadioButton();
        jRadioButton.setBounds(0, y * (i + 1), 100, 50);
        jRadioButton.setText(answer);
        jRadioButton.setActionCommand(answer);
        buttonGroups[i].add(jRadioButton);
        jPanel.add(jRadioButton);
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        int score = 0;
        for (int i = 0; i < buttonGroups.length; i++) {
            Problem problem = list.get(i);
            String actionCommand = buttonGroups[i].getSelection().getActionCommand();
            score += problem.getMap().get(actionCommand);
        }
        JOptionPane.showMessageDialog(this, "得分为: " + score);
        this.dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("evaluation");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());
                contentPanel.add(scrollPane1, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- okButton ----
                okButton.setText(bundle.getString("okButton.text"));
                okButton.addActionListener(e -> okButtonActionPerformed(e));

                //---- cancelButton ----
                cancelButton.setText(bundle.getString("cancelButton.text"));
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                            .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

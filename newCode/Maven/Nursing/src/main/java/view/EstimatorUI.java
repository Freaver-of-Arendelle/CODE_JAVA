/*
 * Created by JFormDesigner on Tue Jul 13 17:26:14 CST 2021
 */

package view;

import controller.EstimatorController;
import controller.TemplateController;
import model.bean.Estimator;
import model.bean.Patient;
import model.bean.Template;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ToolBarUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

/**
 * @author Freaver
 */
public class EstimatorUI extends JFrame {


    private static String suggestion;

    public static void setSuggestion(String suggestion) {
        EstimatorUI.suggestion = suggestion;
    }

    private static Vector<Template> vector = new Vector<>(TemplateController.getSingleton().getTemplates());

    public EstimatorUI() {
        initComponents();
        selInit(selCB, vector);
    }

    public EstimatorUI(Vector<Estimator> estimators) {
        initComponents();
        selInit(selCB, vector);
        refresh(((DefaultTableModel) table1.getModel()), estimators);
    }

    /**
     * 根据提供的vector对JComboBox进行初始化
     *
     * @param selCB
     * @param vector
     */
    private static void selInit(JComboBox selCB, Vector<Template> vector) {
        Vector<String> strings = new Vector<>();
        strings.add("请选择模板");
        selCB.removeAllItems();
        for (Template template : vector) {
            strings.add(template.getTitle());
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
    public static void init(DefaultTableModel model, Vector<Estimator> vector) {
        int size = vector.size();

        for (int i = 0; i < size; i++) {
            Vector<Object> objects = new Vector<>();
            Estimator estimator = vector.get(i);
            objects.add(estimator.getName());
            objects.add(estimator.getGender());
            objects.add(estimator.getTemplateName());
            objects.add(estimator.getTemplateType());
            objects.add(estimator.getDate());
            objects.add(estimator.getAppraiser());
            objects.add(estimator.getSuggestion());
            model.addRow(objects);
        }
    }

    /**
     * 根据提供的model和vector来调用init方法并且重绘
     *
     * @param model
     * @param vector
     */
    private void refresh(DefaultTableModel model, Vector<Estimator> vector) {
        model.getDataVector().clear();
        init(model, vector);
        table1.setModel(model);
        table1.repaint();
    }


    public static void main(String[] args) {
        new EstimatorUI().setVisible(true);

    }

    private void startBtnActionPerformed(ActionEvent e) {

//        new Estimator(((String) tempVector.get(0)), ((String) tempVector.get(1)),
//                ((String) tempVector.get(2)), ((String) tempVector.get(3)),
//                ((Date) tempVector.get(4)), ((String) tempVector.get(5)),
//                ((String) tempVector.get(6)))

        String title = (String) selCB.getSelectedItem();
        for (Template template : vector) {
            if (template.getTitle().equals(title)) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                var selectedRow = table1.getSelectedRow();
                Vector<Vector> dataVector = model.getDataVector();
                EvaluationUI ui = new EvaluationUI(template, model, dataVector, selectedRow);
                this.dispose();
                ui.setVisible(true);

                return;
            }
        }
    }


    private void cancelBtnActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        Vector<Vector> dataVector = model.getDataVector();
        EstimatorController singleton = EstimatorController.getSingleton();
        for (Vector vector1 : dataVector) {
            singleton.addEstimator(new Estimator(((String) vector1.get(0)),
                    ((String) vector1.get(1)), ((String) vector1.get(2)),
                    ((String) vector1.get(3)), ((Date) vector1.get(4)),
                    ((String) vector1.get(5)), ((String) vector1.get(6))
            ));

        }
        this.dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("esimator");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        startBtn = new JButton();
        selCB = new JComboBox();
        buttonBar = new JPanel();
        cancelBtn = new JButton();

        //======== this ========
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
                            "\u59d3\u540d", "\u6027\u522b", "\u6a21\u677f\u540d\u79f0", "\u6a21\u677f\u7c7b\u578b", "\u65f6\u95f4", "\u8bc4\u4f30\u4eba", "\u5efa\u8bae"
                        }
                    ) {
                        Class<?>[] columnTypes = new Class<?>[] {
                            String.class, String.class, String.class, String.class, Date.class, String.class, String.class
                        };
                        @Override
                        public Class<?> getColumnClass(int columnIndex) {
                            return columnTypes[columnIndex];
                        }
                    });
                    scrollPane1.setViewportView(table1);
                }

                //---- startBtn ----
                startBtn.setText(bundle.getString("startBtn.text"));
                startBtn.addActionListener(e -> startBtnActionPerformed(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(startBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 408, Short.MAX_VALUE)
                            .addComponent(selCB, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(selCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(startBtn)))
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- cancelBtn ----
                cancelBtn.setText(bundle.getString("cancelBtn.text"));
                cancelBtn.addActionListener(e -> cancelBtnActionPerformed(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, buttonBarLayout.createSequentialGroup()
                            .addContainerGap(455, Short.MAX_VALUE)
                            .addComponent(cancelBtn, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addGap(124, 124, 124))
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, buttonBarLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(cancelBtn))
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
    private JTable table1;
    private JButton startBtn;
    private JComboBox selCB;
    private JPanel buttonBar;
    private JButton cancelBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

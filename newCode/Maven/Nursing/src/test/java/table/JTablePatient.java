package table;

import model.bean.Patient;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class JTablePatient extends AbstractTableModel {

    private Vector<Patient> tableData;
    private Vector<String> tableTitle;

    public JTablePatient() {
        tableData = new Vector<>();
        tableTitle = new Vector<>();


        tableTitle.add("");
        tableTitle.add("姓名");
        tableTitle.add("出生日期");
        tableTitle.add("性别");
        tableTitle.add("身份证号");
        tableTitle.add("联系电话");
        tableTitle.add("紧急联系人");
        tableTitle.add("紧急联系人电话");
        tableTitle.add("评估");
    }

    private static final long serialVersionUID = 1L;
    private static final String[] COLUMN_NAMES = new String[]{"", "姓名", "出生日期", "性别", "身份证号",
            "联系电话", "紧急联系人", "紧急联系人电话", "评估"};
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[]{Boolean.class, String.class, String.class,
            String.class, String.class, String.class, String.class, String.class, JButton.class};

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public int getRowCount() {
        return 9;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        /*Adding components*/
        Patient patient = tableData.get(rowIndex);

        switch (columnIndex) {
            case 1:
                return patient.getName();
            case 2:
                return patient.getBirthday();
            case 3:
                return patient.getGender();
            case 4:
                return patient.getId();
            case 5:
                return patient.getTel();
            case 6:
                return patient.getEmergencyContact();
            case 7:
                return patient.getEmergencyTel();
            default:
                return null;
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 8:
                return false;
            default:
                return true;
        }
    }
}


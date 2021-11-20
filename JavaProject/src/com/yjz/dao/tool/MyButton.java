package com.yjz.dao.tool;

import javax.swing.JButton;
//通过继承，得到特殊的按钮
public class MyButton extends JButton {
	private int row;

    private int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public MyButton() {

    }

    public MyButton(String name) {
        super(name);
    }
}

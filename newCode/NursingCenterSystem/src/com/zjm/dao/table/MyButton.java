package com.zjm.dao.table;

import javax.swing.JButton;

public class MyButton extends JButton {
	/*
	 * 为了点击表格中的评估按钮，需要获取行列数据
	 * 写MyButton类继承JButton并加上row与column属性用来存储行列
	 */
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

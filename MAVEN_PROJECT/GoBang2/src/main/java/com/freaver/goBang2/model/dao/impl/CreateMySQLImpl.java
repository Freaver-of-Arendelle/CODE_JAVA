package com.freaver.goBang2.model.dao.impl;

import com.freaver.goBang2.model.dao.Create;
import com.freaver.goBang2.view.utils.Tools;

import java.sql.Connection;

/**
 * @author Freaver
 * @date 11/5/2021 11:44
 */
public class CreateMySQLImpl implements Create {

    private Connection connection;
    String table;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Override public boolean add(Object o) {
        return Tools.insert(connection, table, connection);
    }

}

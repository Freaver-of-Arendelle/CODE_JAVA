package com.freaver.goBang2.model.dao.impl;

import com.freaver.goBang2.model.dao.Update;

import java.sql.Connection;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 11/5/2021 11:47
 */
public class UpdateMySQLImpl implements Update {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override public boolean modify(Object object, Predicate filter) {
        return false;
    }

}

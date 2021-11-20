package com.freaver.goBang2.model.dao.impl;

import com.freaver.goBang2.model.dao.Delete;

import java.sql.Connection;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 11/5/2021 11:46
 */
public class DeleteMySQLImpl implements Delete {


    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override public boolean remove(Object object, Predicate filter) {
        return false;
    }


    @Override public boolean clear() {
        return false;
    }
}

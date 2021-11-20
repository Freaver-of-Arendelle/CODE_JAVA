package com.freaver.goBang2.model.dao.impl;

import com.freaver.goBang2.model.dao.Retrieve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 11/5/2021 11:46
 */
public class RetrieveMySQLImpl<T> implements Retrieve {

    private Connection connection;
    private String tableName;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override public List<T> get() {
        String sql = "SHOW FULL COLUMNS FROM " + tableName;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            ArrayList<T> list = new ArrayList<>();
            while(rs.next()) {
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

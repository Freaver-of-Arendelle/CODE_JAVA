package com.freaver.goBang2.model.service;

import com.freaver.goBang2.model.dao.Create;
import com.freaver.goBang2.model.dao.Delete;
import com.freaver.goBang2.model.dao.Retrieve;
import com.freaver.goBang2.model.dao.Update;
import com.freaver.goBang2.model.dao.impl.CreateMySQLImpl;
import com.freaver.goBang2.model.dao.impl.DeleteMySQLImpl;
import com.freaver.goBang2.model.dao.impl.RetrieveMySQLImpl;
import com.freaver.goBang2.model.dao.impl.UpdateMySQLImpl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Freaver
 * @date 11/5/2021 11:49
 */
public class MySQLService implements Service {

    private String db;

    private Properties properties;
    private String url;
    private String userName;
    private String password;
    private Connection connection;

    private CreateMySQLImpl create;
    private RetrieveMySQLImpl read;
    private UpdateMySQLImpl update;
    private DeleteMySQLImpl delete;

    public MySQLService(String db) {
        this.db = db;
        InputStream is = MySQLService.class.getClassLoader().getResourceAsStream("mysql.properties");
        properties = new Properties();
        userName = properties.getProperty("userName");
        password = properties.getProperty("password");
        url = properties.getProperty("url");
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override public Retrieve getRead() {
        read = new RetrieveMySQLImpl();
        read.setConnection(connection);
        return read;
    }

    @Override public Create getCreate() {
        create = new CreateMySQLImpl();
        create.setConnection(connection);
        return create;
    }

    @Override public Update getUpdate() {
        update = new UpdateMySQLImpl();
        update.setConnection(connection);
        return update;
    }

    @Override public Delete getDelete() {
        delete = new DeleteMySQLImpl();
        delete.setConnection(connection);
        return delete;
    }
}

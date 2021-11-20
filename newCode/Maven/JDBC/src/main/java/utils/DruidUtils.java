package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.sql.ast.statement.SQLShowPartitionsStmt;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Freaver
 * @date 07/05/2021 22:12
 */
public class DruidUtils {

    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    static {
        try {
            Properties pro = new Properties();

            InputStream is = ClassLoader.getSystemResourceAsStream("druid.properties");

            pro.load(is);

            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();

    }

    public static void close(Statement statement, Connection connection) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement, Connection connection, ResultSet resultSet) {
        close(statement, connection);

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

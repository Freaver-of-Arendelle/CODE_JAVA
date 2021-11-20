package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.Stack;

/**
 * @author Freaver
 * @date 07/05/2021 15:52
 */
public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;


    static {



        try {
            URL resource = ClassLoader.getSystemResource("jdbc.properties");
//            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
//            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();

            Properties properties = new Properties();


            properties.load(new FileReader(path));

            user = properties.getProperty("user");
            driver = properties.getProperty("driver");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            Class.forName(driver);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(url, user, password);
    }


    public static void close(Connection connection, Statement statement) {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void close(ResultSet resultSet, Connection connection, Statement statement) {
        close(connection, statement);

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

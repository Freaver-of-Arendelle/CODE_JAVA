package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freaver
 * @date 07/05/2021 14:06
 */
public class JDBCDemo2 {
    public static void main(String[] args) {

        Connection connection = null;

        Statement stmt = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "admin");

            String sql = "INSERT INTO student set name =  'Freaver', age = 30";

            stmt = connection.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
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

    }


}

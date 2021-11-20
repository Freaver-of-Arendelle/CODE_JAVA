package demo;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freaver
 * @date 07/05/2021 13:51
 */
public class JDBCDemo1 {

    public static void main(String[] args) {

        Connection connection = null;

        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "admin");

            String sql = "update student set age = 30 where name = 'Freaver'";

            stmt = connection.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

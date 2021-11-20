package demo;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Freaver
 * @date 07/05/2021 16:09
 */
public class JDBCDemo6 {
    public static void main(String[] args) {

        Connection connection = null;

        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;


        try {
            connection = JDBCUtils.getConnection();

            String sql = "UPDATE account SET balance = balance - ? WHERE id = ?";

            connection.setAutoCommit(false);

            statement1 = connection.prepareStatement(sql);
            statement2 = connection.prepareStatement(sql);

            statement1.setInt(1, 500);
            statement1.setInt(2, 1);

            statement2.setInt(1, 500);
            statement2.setInt(2, 2);

            statement1.executeUpdate();
            statement2.executeUpdate();

            int a = 3 / 0;

            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtils.close(connection, statement1);
            JDBCUtils.close(connection, statement2);
        }
    }
}

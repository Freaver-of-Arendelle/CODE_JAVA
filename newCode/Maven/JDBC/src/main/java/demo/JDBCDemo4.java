package demo;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Freaver
 * @date 07/05/2021 16:09
 */
public class JDBCDemo4 {
    public static void main(String[] args) {
        String name;
        String password;
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        password = in.nextLine();

        Connection connection = null;

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            statement = connection.createStatement();

            String sql = "SELECT * FROM user WHERE name = '" + name + "'" +
                    " and password = '" + password + "'";
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("login success");
            } else {
                System.out.println("login faild");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, connection, statement);
        }
    }
}

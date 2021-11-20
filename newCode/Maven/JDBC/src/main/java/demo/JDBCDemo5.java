package demo;

import utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Freaver
 * @date 07/05/2021 16:09
 */
public class JDBCDemo5 {
    public static void main(String[] args) {
        String name;
        String password;
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        password = in.nextLine();

        Connection connection = null;

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "SELECT * FROM user WHERE name = ? and password = ?";

            statement = connection.prepareStatement(sql);

            statement.setString(1, name);

            statement.setString(2, password);

            resultSet = statement.executeQuery();

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

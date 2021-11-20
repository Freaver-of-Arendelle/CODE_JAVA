package demo;

import bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 07/05/2021 14:48
 */
public class JBDCDemo3 {

    private static List<Student> students = new ArrayList<>();

    private static Connection connection = null;

    private static Statement statement = null;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql:///db1", "root", "admin");

            String sql = "select * from student";

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(name, age));
            }

            for (Student student : students) {
                System.out.println(student);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
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
    }
}

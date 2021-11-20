import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Freaver
 * @date 5/16/2021
 */
public class demo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "admin");
        String sql = "SELECT *\n" +
                "FROM emp JOIN dept d ON emp.dept_id = d.id;";
        Statement statement = connection.createStatement();

        boolean i = statement.execute(sql);

        System.out.println(i);


    }
}

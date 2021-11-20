package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import utils.DruidUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Freaver
 * @date 07/05/2021 22:05
 */
public class DruidDemo {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM account WHERE id = ?";
        ResultSet resultSet = null;

        try {
            connection = DruidUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + "-----" + resultSet.getInt("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(preparedStatement, connection, resultSet);
        }
    }
}

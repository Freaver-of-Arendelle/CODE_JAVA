package template;

import bean.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.DruidUtils;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Freaver
 * @date 07/06/2021 09:22
 */
public class SpringJDBCDemo {

    @Test
    public void test1() {
        DataSource ds = DruidUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "SELECT * FROM emp;";
        List<Map<String, Object>> maps = template.queryForList(sql);

        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void test2() {
        DataSource ds = DruidUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "SELECT * FROM emp WHERE id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);

        System.out.println(map);
    }

    @Test
    public void test3() {
        DataSource ds = DruidUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "SELECT * FROM emp";

        List<Emp> emps = template.query(sql, (resultSet, i) -> {
            Emp emp = new Emp();
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Date date = resultSet.getDate("date");
            double salary = resultSet.getDouble("salary");
            emp.setId(id);
            emp.setName(name);
            emp.setDate(date);
            emp.setSalary(salary);
            return emp;
        });

        for (Emp emp : emps) {
            System.out.println(emp);
        }

    }

    @Test
    public void test4() {
        DataSource ds = DruidUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "SELECT * FROM emp";

        List<Emp> emps = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));

        for (Emp emp : emps) {
            System.out.println(emp);
        }

    }

    @Test
    public void test5() {
        DataSource ds = DruidUtils.getDataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        String sql = "SELECT count(id) FROM emp";

        Integer i = template.queryForObject(sql, Integer.class);

        System.out.println(i);

    }
}

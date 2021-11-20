package com.freaver.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.freaver.config.DataSourceConfig;
import com.freaver.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Author freaver
 * @Date 11/15/2021 01:10
 */
public class Client {
    @Test
    public void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = app.getBean("userService", UserService.class);
        userService.save();
    }

    @Test
    public void testC3p0() throws Exception{
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        ComboPooledDataSource dataSource = app.getBean("c3p0", ComboPooledDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testDruid() throws Exception{

        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        DruidDataSource dataSource = app.getBean("druid", DruidDataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testDataBase() throws Exception {
        ApplicationContext app = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        DataSource c3p0DataSource = app.getBean("c3p0DataSource", DataSource.class);
        System.out.println(c3p0DataSource.getConnection());
        DataSource druidDataSource = app.getBean("druidDataSource", DataSource.class);
        System.out.println(druidDataSource.getConnection());
    }

}

package com.freaver.dao.impl;

import com.freaver.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Author freaver
 * @Date 11/15/2021 00:52
 */
@Repository("userDao")
@Scope("singleton")
public class UserDaoImpl implements UserDao {
    @Value("test")
    private String str;
    @Value("${jdbc.driver}")
    private String driver;
    @Override public void save() {
        System.out.println(str);
        System.out.println(driver);
        System.out.println("UserDao running");
    }

    @Test
    public void test() {
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = app.getBean("userDao", UserDao.class);
        userDao.save();
    }
    @Test
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = app.getBean("userDaoStaticFactory", UserDao.class);
        userDao.save();
    }
    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = app.getBean("userDaoDynamicFactory", UserDao.class);
        userDao.save();
    }
}

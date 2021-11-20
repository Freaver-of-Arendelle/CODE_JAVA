package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @Author: Freaver
 * @Date: 3/26/2021  23:54
 */


//<bean id="UserDao" class="com.itheima.dao.impl.UserDaoImpl"></bean>
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Value("test")
    private String driver;


    @Override public void save() {
        System.out.println("save running");
        System.out.println(driver);
    }

//    public UserDaoImpl() {
//        System.out.println("UserDao was created");
//    }

    public void init() {
        System.out.println("init method");
    }

    public void destroy() {
        System.out.println("destroy method");
    }
}

package com.freaver.factory;

import com.freaver.dao.UserDao;
import com.freaver.dao.impl.UserDaoImpl;

/**
 * @Author freaver
 * @Date 11/15/2021 01:01
 */
public class StaticFactoryBean {
    public static UserDao createUserDao() {
        return new UserDaoImpl();
    }
}

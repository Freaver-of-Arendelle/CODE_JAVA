package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  12:37
 */
public class DynamicFactory {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}

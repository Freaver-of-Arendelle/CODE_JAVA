package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: Freaver
 * @Date: 3/31/2021  16:10
 */
@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("save running");
    }
}

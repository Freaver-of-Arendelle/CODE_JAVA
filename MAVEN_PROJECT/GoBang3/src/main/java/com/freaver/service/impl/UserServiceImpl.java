package com.freaver.service.impl;

import com.freaver.dao.UserDao;
import com.freaver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author freaver
 * @Date 11/15/2021 01:08
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name="userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override public void save() {
        userDao.save();
    }

}

package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Author: Freaver
 * @Date: 3/31/2021  16:11
 */
@Service("UserService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Resource(name = "UserDao") private UserDao userDao;

    @Value("${jdbc.driver}") private String driver;

    public void save() {
        userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("Service init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Service destroy method");
    }


}

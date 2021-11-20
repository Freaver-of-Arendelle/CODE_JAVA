package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  13:11
 */

//<bean id="UserService" class="com.itheima.service.impl.UserServiceImpl" >
@Service("UserService")
public class UserServiceImpl implements UserService {


//        <property name="userDao" ref="UserDao"></property>
//    @Autowired
//    @Qualifier("UserDao")
    @Resource(name = "UserDao")
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
        this.userDao = userDao;
    }



//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override public void save() {
        userDao.save();
    }
}

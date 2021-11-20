package service.impl;

import dao.impl.UserDao;
import service.UserService;

/**
 * @author Freaver
 * @date 5/14/2021
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void show() {
        userDao.show();
        System.out.println("UserService");
    }
}

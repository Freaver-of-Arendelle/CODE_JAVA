package controller.impl;

import framework.context.ApplicationContext;
import framework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * @author Freaver
 * @date 5/14/2021
 */
public class UserControllerImpl implements UserController{
    private UserService userService;

    public UserControllerImpl() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        userService = (UserService) app.getBean("userService");
    }

    @Override
    public void show() {
        userService.show();
        System.out.println("UserController");
    }
}

package com.itheima.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  13:12
 */


public class userController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app = new FileSystemXmlApplicationContext("D:\\CODE\\CODE_JAVA\\Spring-learning\\itheima_spring_ioc\\src\\main\\resources\\applicationContext.xml");
//        UserService userService = (UserService)app.getBean("UserService");
        UserModel userModel = app.getBean(UserModel.class);
        System.out.println(userModel.toString());
//        userService.save();

    }
}

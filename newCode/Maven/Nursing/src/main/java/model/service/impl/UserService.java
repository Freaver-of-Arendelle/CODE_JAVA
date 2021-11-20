package model.service.impl;

import model.service.JSONService;

/**
 * @author Freaver
 * @Time 07/12/2021 10:36
 * @Description
 */
@Deprecated
public class UserService extends JSONService {

    private UserService() {
    }

    private volatile static UserService singleton;


    public static UserService getSingleton() {
        if (singleton == null) {
            synchronized (UserService.class) {
                if (singleton == null) {
                    singleton = new UserService();
                    setPath("src/main/resources/data/user.json");
                }
            }
        }

        return singleton;
    }

}

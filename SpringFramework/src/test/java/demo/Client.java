package demo;

import controller.impl.UserController;
import controller.impl.UserControllerImpl;

/**
 * @author Freaver
 * @date 5/14/2021
 */
public class Client {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserControllerImpl();

        userController.show();
    }
}

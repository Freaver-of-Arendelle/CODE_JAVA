package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.controller.UserSecureController;
import com.freaver.goBang2.model.bean.User;
import com.freaver.goBang2.view.ChangeApp;
import com.freaver.goBang2.view.GoBangApp;
import com.freaver.goBang2.view.RegisterApp;
import com.freaver.goBang2.view.utils.FXTools;
import com.freaver.goBang2.view.utils.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.util.List;

/**
 * @author Freaver
 */
public class LoginController {
    @FXML private AnchorPane frame;
    @FXML private PasswordField pwText;
    @FXML private Button loginBtn;

    @FXML private TextField userText;
    @FXML private Button registerBtn;

    @FXML void login(ActionEvent event) throws Exception {
        //        UserSecureController controller = UserSecureController.getSingleton();
        //        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //        UserSecureController controller =
        //            applicationContext.getBean("userSecureController", UserSecureController.class);
        UserSecureController controller = UserSecureController.getSingleton();
        List<User> users = controller.getUsers();
        String name = userText.getText();
        String password = pwText.getText();
        int flag = 0;
        for (var user : users) {
            if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                if (user.getPhone().isBlank()) {
                    flag = 2;
                } else {
                    flag = 1;
                }
                break;
            }
        }
        if (flag == 1) {
            GoBangApp app = new GoBangApp();
            FXTools.init(loginBtn, app);
        } else if (flag == 2) {
            ChangeApp app = new ChangeApp();
            FXTools.init(loginBtn, app);
            app.addListener();
            app.setUserName(name);
        } else {
            Tools.popAlert("用户名或密码错误");
        }

    }

    @FXML void register(ActionEvent event) throws Exception {
        RegisterApp app = new RegisterApp();
        FXTools.init(registerBtn, app);

    }

}

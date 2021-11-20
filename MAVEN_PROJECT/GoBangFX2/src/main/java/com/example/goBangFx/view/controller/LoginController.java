package com.example.goBangFx.view.controller;

import com.example.goBangFx.controller.UserSecureController;
import com.example.goBangFx.model.bean.User;
import com.example.goBangFx.view.GoBangApp;
import com.example.goBangFx.view.RegisterApp;
import com.example.goBangFx.view.utils.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.context.ApplicationContext;

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
        ApplicationContext applicationContext = Tools.getApplicationContext();
        UserSecureController singleton = applicationContext.getBean("userSecureController", UserSecureController.class);
        List<User> users = singleton.getUsers();
        String name = userText.getText();
        String password = pwText.getText();
        Boolean b = false;
        boolean flag = false;
        for (var user : users) {
            if (name.equals(user.getName()) && password.equals(user.getPassword()) && b.equals(
                user.getIsAdministrator())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            GoBangApp app = new GoBangApp();
            Tools.init(loginBtn, app);
            app.setUserName(name);

        }

    }

    @FXML void register(ActionEvent event) throws Exception {
        RegisterApp app = new RegisterApp();
        Tools.init(registerBtn, app);

    }


}

package com.example.goBangFx.view.controller;

import com.example.goBangFx.controller.UserSecureController;
import com.example.goBangFx.view.LoginApp;
import com.example.goBangFx.view.utils.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

/**
 * @author Freaver
 */

public class RegisterController {

    @FXML private PasswordField pwText;
    @FXML private Button registerBtn;

    @FXML private TextField userText;
    @FXML private AnchorPane frame;

    @FXML void register(ActionEvent event) throws Exception {
        ApplicationContext applicationContext = Tools.getApplicationContext();
        UserSecureController singleton = applicationContext.getBean("userSecureController", UserSecureController.class);
        String user = userText.getText();
        String pw = pwText.getText();
        if (singleton.addUser(user, pw, false)) {
            Stage stage = new Stage();
            stage.setScene(new Scene(new Button("注册成功"), 100, 100));
            stage.show();
            LoginApp app = new LoginApp();
            Tools.init(registerBtn, app);
        }
    }

}

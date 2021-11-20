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

/**
 * @author Freaver
 */

public class RegisterController {

    @FXML private PasswordField pwText;
    @FXML private Button registerBtn;

    @FXML private TextField userText;
    @FXML private AnchorPane frame;

    @FXML void Register(ActionEvent event) throws Exception {
        UserSecureController singleton = UserSecureController.getSingleton();
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

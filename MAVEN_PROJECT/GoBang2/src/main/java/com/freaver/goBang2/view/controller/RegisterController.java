package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.controller.UserSecureController;
import com.freaver.goBang2.model.bean.User;
import com.freaver.goBang2.view.LoginApp;
import com.freaver.goBang2.view.utils.FXTools;
import com.freaver.goBang2.view.utils.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Freaver
 */
@Deprecated
public class RegisterController {

    @FXML private PasswordField pwText;
    @FXML private Button registerBtn;

    @FXML private TextField userText;
    @FXML private AnchorPane frame;

    @FXML private Label nameLabel;

    @FXML private Label pwLabel;

    private boolean flag1 = false;

    @FXML void Register(ActionEvent event) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserSecureController singleton = applicationContext.getBean("userSecureController", UserSecureController.class);
        //        UserSecureController singleton = UserSecureController.getSingleton();

        userText.textProperty().addListener((observableValue, s, t1) -> {

            String user = userText.getText();

            List<User> users = singleton.getUsers();
            if (users.size() != 0) {
                nameLabel.setText("该用户已存在");
                flag1 = false;
            } else {
                flag1 = true;
                nameLabel.setText("");
            }
        });

        String password = pwText.getText();
        Tools.addListener(pwText, pwLabel);

        boolean flag2 = false;
//        pwText.textProperty().addListener((observableValue, s, t1) -> {
//            String pw = pwText.getText();
//            String pattern = "^{6}\\w$";
//            if (Pattern.matches(pattern, pw)) {
//                flag2 = true;
//                pwLabel.setText("");
//            } else {
//                flag2 = false;
//                pwLabel.setText("密码格式错误");
//            }
//        });
        String user = userText.getText();
        List<User> users = singleton.getUsers();
        if (flag1 && flag2) {
            if (singleton.addUser(user, password)) {
                Stage stage = new Stage();
                stage.setScene(new Scene(new Button("注册成功"), 100, 100));
                stage.show();
                LoginApp app = new LoginApp();
                FXTools.init(registerBtn, app);
            }
        } else {
            Tools.popAlert("注册失败");
        }
    }

}

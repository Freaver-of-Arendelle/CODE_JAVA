package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.controller.UserSecureController;
import com.freaver.goBang2.model.bean.User;
import com.freaver.goBang2.view.GoBangApp;
import com.freaver.goBang2.view.utils.FXTools;
import com.freaver.goBang2.view.utils.Tools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class ChangeController {

    @FXML private Button okBtn;

    @FXML private TextField phoneText;

    @FXML private TextField pwText;

    @FXML private Label pwLabel;

    @FXML private Label phoneLabel;

    private boolean flag2;
    private boolean flag1;

    private String userName;
    private String phone;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void addListener() {
        Tools.addListener(pwText, pwLabel);
        phoneText.focusedProperty().addListener(((observableValue, s, t1) -> {
            phone = phoneText.getText();
            String pattern = "^\\d{11}$";
            if (Pattern.matches(pattern, phone)) {
                flag2 = true;
                phoneLabel.setText("");
            } else {
                flag2 = false;
                phoneLabel.setText("电话号码格式错误");
            }
        }));
    }

    @FXML void confirmAction(ActionEvent event) throws Exception {
        String password = pwText.getText();
        boolean flag1 = Pattern.matches("\\w{6}", password);

        if (flag1 && flag2) {
//            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
            UserSecureController singleton =
//                applicationContext.getBean("userSecureController", UserSecureController.class);
            singleton = UserSecureController.getSingleton();
            singleton.modifyUser(userName, new User(userName, password, phone));
            GoBangApp app = new GoBangApp();
            FXTools.init(okBtn, app);
        } else {
            Tools.popAlert("更改失败");
        }

    }

}

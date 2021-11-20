package com.freaver.goBang2.view;

import com.freaver.goBang2.view.controller.ChangeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author freaver
 * @Date 11/11/2021 23:30
 */
public class ChangeApp extends Application {
    ChangeController controller;
    @Override public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ReplayListApp.class.getResource("change.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }

    public void addListener() {
        controller.addListener();
    }

    public void setUserName(String userName) {
        controller.setUserName(userName);
    }
}

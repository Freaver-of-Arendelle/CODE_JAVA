package com.example.goBangFx.view;

import com.example.goBangFx.model.bean.Board;
import com.example.goBangFx.view.controller.GoBangController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Freaver
 * @date 10/13/2021
 * @time 18:41
 */
public class GoBangApp extends Application {
    private GoBangController controller;
    @Override public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(GoBangApp.class.getResource("goBang.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }


    public void replay(Board board) {

       controller.replay(board);
    }

    public void setUserName(String userName) {
        controller.setUserName(userName);
    }
}

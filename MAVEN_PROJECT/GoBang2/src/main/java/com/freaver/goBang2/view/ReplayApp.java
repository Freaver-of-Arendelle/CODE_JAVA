package com.freaver.goBang2.view;

import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.view.controller.ReplayController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author freaver
 * @Date 11/11/2021 23:30
 */
public class ReplayApp extends Application {
    ReplayController controller;
    @Override public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ReplayListApp.class.getResource("replay.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }

    public void setBoard(Board board) {
        controller.setBoard(board);
    }


}

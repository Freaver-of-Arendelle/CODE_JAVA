package com.freaver.goBang2.view;

import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.view.controller.GoBangController;
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

    public void continueBoard(Board board) {
        controller.continueBoard(board);
    }

}

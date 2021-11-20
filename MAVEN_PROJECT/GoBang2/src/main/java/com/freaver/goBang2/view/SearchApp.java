package com.freaver.goBang2.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author freaver
 * @Date 11/11/2021 23:30
 */
public class SearchApp extends Application {
    @Override public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ReplayListApp.class.getResource("Search.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}

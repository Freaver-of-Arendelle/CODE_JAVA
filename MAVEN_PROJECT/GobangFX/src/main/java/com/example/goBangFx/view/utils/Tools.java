package com.example.goBangFx.view.utils;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author Freaver
 * @date 10/17/2021
 * @time 01:44
 */
public class Tools {

    public static void init(Button button, Application app) throws Exception {
        Stage primaryStage = (Stage)button.getScene().getWindow();
        primaryStage.close();
        app.start(new Stage());
    }

    public static String millsToString(long mills) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.systemDefault()));
    }
}

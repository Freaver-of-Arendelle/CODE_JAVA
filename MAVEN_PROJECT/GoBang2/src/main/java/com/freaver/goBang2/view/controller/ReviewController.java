package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.view.utils.FXTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ReviewController {

    @FXML private Canvas draw;

    @FXML private Button narrowBtn;

    @FXML private Button returnBtn;

    @FXML private Pane root;

    @FXML private Button zoomBtn;

    private GraphicsContext gc;
//    private final int DIAMETER = 40;
    @FXML void narrowAction(ActionEvent event) {
        Stage stage = (Stage)narrowBtn.getScene().getWindow();
        stage.setMaximized(false);
    }

    @FXML void returnAction(ActionEvent event) {
        FXTools.exit(returnBtn);
    }

    @FXML void zoomAction(ActionEvent event) {

        Stage stage = (Stage)zoomBtn.getScene().getWindow();
        stage.setMaximized(true);
    }

    public void review(Board board) {
        FXTools.draw(board, gc, draw);
    }

}

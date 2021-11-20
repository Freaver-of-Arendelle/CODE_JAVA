package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.view.utils.FXTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ReplayController {


    private GraphicsContext gc;
//    private final int DIAMETER = 40;

    @FXML
    private Button backBtn;

    @FXML
    private Canvas draw;

    @FXML
    private Button frontBtn;

    @FXML
    private Button replayBtn;

    @FXML
    private Button returnBtn;

    @FXML
    private Pane root;

    @FXML
    private Button stopBtn;

    private Board board;

    @FXML
    void backAction(ActionEvent event) throws InterruptedException {
        FXTools.back(gc, draw);

    }

    @FXML
    void frontAction(ActionEvent event) throws InterruptedException {
        FXTools.front(gc, draw);

    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @FXML void replayAction(ActionEvent event) {
        gc = draw.getGraphicsContext2D();
        FXTools.replay(board, gc, draw);

    }

    @FXML void returnAction(ActionEvent event) {
        FXTools.exit(returnBtn);
    }

    @FXML void stopAction(ActionEvent event) throws InterruptedException {
        FXTools.stop();
    }


}

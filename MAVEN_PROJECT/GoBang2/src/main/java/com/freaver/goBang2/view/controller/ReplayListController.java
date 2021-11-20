package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.controller.BoardController;
import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.view.GoBangApp;
import com.freaver.goBang2.view.ReplayApp;
import com.freaver.goBang2.view.ReviewApp;
import com.freaver.goBang2.view.tableBean.BoardReplayTable;
import com.freaver.goBang2.view.utils.FXTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Freaver
 * @date 10/16/2021
 */
public class ReplayListController implements Initializable {
    @FXML private Button replayBtn;
    @FXML private Button reviewBtn;
    @FXML private Button continueBtn;
    @FXML private Button returnBtn;

    @FXML private TableView<BoardReplayTable> table;
    @FXML private TableColumn<?, ?> whiteColumn;
    @FXML private TableColumn<?, ?> blackColumn;
    @FXML private TableColumn<?, ?> winColumn;

    private void showList() {
        List<Board> boards = BoardController.getSingleton().getBoards();
        FXTools.initData(boards, winColumn, whiteColumn, blackColumn, table);
    }

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        showList();
    }

    @FXML void replayAction(ActionEvent event) throws Exception {
        ReplayApp app = new ReplayApp();
        Board board = FXTools.getSelectedBoard(table);
        FXTools.init(replayBtn, app);
        app.setBoard(board);
        //        GoBangController.setBoard(board);
        //        ((Node)event.getSource()).getScene().getWindow().hide();
        //        GoBangController.
    }
    @FXML
    void reviewAction(ActionEvent event) throws Exception {
        ReviewApp app = new ReviewApp();
        Board board = FXTools.getSelectedBoard(table);
        FXTools.init(reviewBtn, app);
        app.review(board);

    }

    @FXML
    void continueAction(ActionEvent event) throws Exception {
        GoBangApp app = new GoBangApp();
        Board board = FXTools.getSelectedBoard(table);
        FXTools.init(continueBtn, app);
        app.continueBoard(board);
    }

    @FXML
    void returnAction(ActionEvent event) {
        FXTools.exit(returnBtn);
    }
}

package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.controller.BoardController;
import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.view.ReplayApp;
import com.freaver.goBang2.view.ReviewApp;
import com.freaver.goBang2.view.tableBean.BoardReplayTable;
import com.freaver.goBang2.view.utils.FXTools;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

/**
 * @author Freaver
 */
public class SearchController {
    @FXML private TableColumn<?, ?> blackColumn;

    @FXML private TextField blackName;

    @FXML private Button exitBtn;

    @FXML private Button replayBtn;

    @FXML private Button reviewBtn;

    @FXML private Button searchBtn;

    @FXML private TableView<BoardReplayTable> table;

    @FXML private TableColumn<?, ?> whiteColumn;

    @FXML private TextField whiteName;

    @FXML private ToggleGroup win;

    @FXML private TableColumn<?, ?> winColumn;


    @FXML void exitAction(ActionEvent event) {
        FXTools.exit(exitBtn);

    }

    @FXML void replayAction(ActionEvent event) throws Exception {
        ReplayApp app = new ReplayApp();
        Board board = FXTools.getSelectedBoard(table);
        FXTools.init(replayBtn, app);
        app.setBoard(board);
    }

    @FXML void reviewAction(ActionEvent event) throws Exception {
        ReviewApp app = new ReviewApp();
        Board board = FXTools.getSelectedBoard(table);
        FXTools.init(reviewBtn, app);

    }

    private void showList(List<Board> boards) {
        FXTools.initData(boards, winColumn, whiteColumn, blackColumn, table);

    }

    @FXML void searchAction(ActionEvent event) {
        var ref = new Object() {
            String winColor = null;
        };
        win.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
            if (win.getSelectedToggle() != null) {
                ref.winColor = win.getSelectedToggle().getUserData().toString();
            }
        });
        if (win.getSelectedToggle().getUserData() != null) {
            ref.winColor = win.getSelectedToggle().getUserData().toString();
        }
        int color;
        if (ref.winColor.equals("黑")) {
            color = 1;
        } else if (ref.winColor.equals("白")) {
            color = 2;
        } else {
            color = 0;
        }
        String blackNameText = blackName.getText();
        String whiteNameText = whiteName.getText();
        BoardController controller = BoardController.getSingleton();
        List<Board> boards = controller.getBoards();
        boards.removeIf(e -> !e.getWhiteName().equals(whiteNameText) && !e.getBlackName().equals(blackNameText)
            && e.getWinner() != color);
        showList(boards);
    }

}

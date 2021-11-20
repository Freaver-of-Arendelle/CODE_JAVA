package com.example.goBangFx.view.controller;

import com.example.goBangFx.controller.BoardController;
import com.example.goBangFx.model.bean.Board;
import com.example.goBangFx.view.GoBangApp;
import com.example.goBangFx.view.tableBean.BoardTable;
import com.example.goBangFx.view.utils.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Freaver
 * @date 10/16/2021
 */
public class ReplayController implements Initializable {
    @FXML private Button replayBtn;

    @FXML private TableView<BoardTable> table;
    @FXML private TableColumn timeColumn;

    @FXML private TableColumn winnerColumn;

    private String userName;

    public void showList() {
        List<Board> boardList;
        BoardController controller = BoardController.getSingleton();
        boardList = controller.getBoard();

        ObservableList<BoardTable> data = FXCollections.observableArrayList();
        for (Board board : boardList) {
            Long boardTime = board.getTime();
            String winner;
            if (board.getWinner() == 1) {
                winner = "黑";
            } else {
                winner = "白";
            }
            data.add(new BoardTable(Tools.millsToString(boardTime), winner));
        }
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        winnerColumn.setCellValueFactory(new PropertyValueFactory<>("winner"));
        table.setItems(data);
    }

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        showList();
    }

    @FXML void replayAction(ActionEvent event) throws Exception {
        GoBangApp app = new GoBangApp();
        BoardTable boardTable = table.getSelectionModel().getSelectedItem();
        List<Board> boards = BoardController.getSingleton().getBoard();
        Board board = null;
        for (Board b : boards) {
            if (Tools.millsToString(b.getTime()).equals(boardTable.getTime())) {
                board = b;
                break;
            }
        }
        Tools.init(replayBtn, app);
        app.replay(board);
        //        GoBangController.setBoard(board);
        //        ((Node)event.getSource()).getScene().getWindow().hide();
        //        GoBangController.

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

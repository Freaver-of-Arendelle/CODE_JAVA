package com.example.goBangFx.view;

import com.example.goBangFx.model.bean.Board;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

/**
 * @author Freaver
 * @date 10/17/2021
 * @time 20:16
 */
public class AppModel {

    private ObjectProperty<Board> board = new SimpleObjectProperty<>();

    public AppModel() {
        this.board = new SimpleObjectProperty<>();
    }

    public Board getBoard() {
        return board.get();
    }

    public ObjectProperty<Board> boardProperty() {
        return board;
    }

    public void setBoard(Board board) {
        this.board.set(board);
    }
}

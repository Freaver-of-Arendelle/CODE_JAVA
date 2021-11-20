package com.freaver.goBang2.controller;


import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.model.bean.Chess;
import com.freaver.goBang2.model.service.SerializationService;
import com.freaver.goBang2.model.service.Service;

import java.util.List;

/**
 * @author Freaver
 * @date 07/12/2021 10:32
 * @description Staff的controller类
 */
public class BoardController {

    private String blackName;
    private String whiteName;
    private final String PATH = "src/main/resources/data/board.dat";;

    private Service service = SerializationService.getSingleton(PATH);

    private BoardController() {

    }

    private static volatile BoardController singleton;

    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */
    public static BoardController getSingleton() {
        if (singleton == null) {
            synchronized (BoardController.class) {
                if (singleton == null) {
                    singleton = new BoardController();
                }
            }
        }

        return singleton;
    }

    public void setName(String blackName, String whiteName) {
        this.blackName = blackName;
        this.whiteName = whiteName;
    }

    public boolean addBoard(List<Chess> chessList, int winner) {
        Board board = new Board(chessList, winner);
        return service.getCreate().add(board);

    }

    public boolean addBoard(Board board) {
        return service.getCreate().add(board);
    }

    public List<Board> getBoards() {
        return (List<Board>)service.getRead().get();
    }

}

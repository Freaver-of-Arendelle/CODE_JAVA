package com.freaver.goBang2.controller;


import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.model.bean.Chess;
import com.freaver.goBang2.model.service.Service;

import java.util.List;

/**
 * @author Freaver
 * @date 07/12/2021 10:32
 * @description Staff的controller类
 */
public class BoardController2 {

    private String blackName;
    private String whiteName;
    private String path;

    private Service service;

    private BoardController2() {

    }

    private static volatile BoardController2 singleton;

    /**
     * 双重检查锁的单例模式
     *
     * @return UserSecureController
     */
    public static BoardController2 getSingleton() {
        if (singleton == null) {
            synchronized (BoardController2.class) {
                if (singleton == null) {
                    singleton = new BoardController2();
                }
            }
        }

        return singleton;
    }

    public void setBlackName(String blackName) {
        this.blackName = blackName;
    }

    public void setWhiteName(String whiteName) {
        this.whiteName = whiteName;
    }

    public boolean addBoard(List<Chess> chessList, int winner) {
        Board board = new Board(chessList, winner);
        return service.getCreate().add(board);

    }

    public boolean addBoard(Board board) {
        return service.getCreate().add(board);
    }

    public List<Board> getBoard() {
        return (List<Board>)service.getRead().get();
    }

}

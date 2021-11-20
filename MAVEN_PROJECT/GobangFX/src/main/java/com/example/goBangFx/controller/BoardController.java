package com.example.goBangFx.controller;

import com.example.goBangFx.model.bean.Board;
import com.example.goBangFx.model.bean.Chess;
import com.example.goBangFx.model.dao.Create;
import com.example.goBangFx.model.dao.Delete;
import com.example.goBangFx.model.dao.Update;
import com.example.goBangFx.model.service.SerializationService;
import com.example.goBangFx.model.service.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Freaver
 * @date 07/12/2021 10:32
 * @description Staff的controller类
 */
public class BoardController {

    private String userName;
    private String path;

    private Service service;

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

    public BoardController setUserName(String userName) {
        this.userName = userName;
        path = "src/main/resources/data/user/" + userName + "/board.bat";
        service = SerializationService.getSingleton(path);
        return singleton;
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

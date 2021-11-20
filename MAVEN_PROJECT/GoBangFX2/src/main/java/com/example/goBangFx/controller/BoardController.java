package com.example.goBangFx.controller;

import com.example.goBangFx.model.bean.Board;
import com.example.goBangFx.model.bean.Chess;
import com.example.goBangFx.model.service.impl.SerializationServiceImpl;
import com.example.goBangFx.model.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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

    //    @Bean(name = "userName")
    public String getUserName() {
        return userName;
    }

    @Bean(name = "path") public String getPath() {
        return path;
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
        ApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        service = app.getBean("boardSerializationService", SerializationServiceImpl.class);
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

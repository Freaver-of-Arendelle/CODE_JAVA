package com.freaver.goBang2.view.utils;

import com.freaver.goBang2.controller.BoardController;
import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.model.bean.Chess;
import com.freaver.goBang2.view.tableBean.BoardReplayTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

/**
 * @Author freaver
 * @Date 11/11/2021 22:06
 */
public class FXTools {

    private final static int DIAMETER = 40;

    private volatile static int i = 0;
    private volatile static boolean flag = true;

    public static void exit(Button button) {
        Stage primaryStage = (Stage)button.getScene().getWindow();
        primaryStage.close();
    }

    public static void start(Application app) throws Exception {
        app.start(new Stage());

    }

    public static void init(Button button, Application app) throws Exception {
        exit(button);
        start(app);
    }

    public static void initData(List<Board> boards, TableColumn<?, ?> winColumn, TableColumn<?, ?> whiteColumn,
        TableColumn<?, ?> blackColumn, TableView<BoardReplayTable> table) {

        ObservableList<BoardReplayTable> data = FXCollections.observableArrayList();
        for (Board board : boards) {
            String blackName = board.getBlackName();
            String whiteName = board.getWhiteName();
            String winner;
            if (board.getWinner() == 1) {
                winner = "黑";
            } else if (board.getWinner() == 2) {
                winner = "白";
            } else {
                winner = "未定";
            }
            data.add(new BoardReplayTable(winner, blackName, whiteName, Tools.millsToString(board.getTime())));
        }
        winColumn.setCellValueFactory(new PropertyValueFactory<>("winner"));
        whiteColumn.setCellValueFactory(new PropertyValueFactory<>("whiteName"));
        blackColumn.setCellValueFactory(new PropertyValueFactory<>("blackName"));
        table.setItems(data);
    }

    public static void drawChess(Integer step, int color, int x, int y, GraphicsContext gc, Canvas draw) {
        gc = draw.getGraphicsContext2D();
        gc.setFont(Font.font(30));
        if (color == 1) {
            gc.setFill(Color.BLACK);

            gc.fillOval(x * 40, y * 40, DIAMETER, DIAMETER);
            //                gc.fillArc(x * 40, y * 40, DIAMETER, DIAMETER, 0, 360, ArcType.ROUND);
            gc.setFill(Color.WHITE);
        } else {
            gc.setFill(Color.WHITE);
            gc.fillOval(x * 40, y * 40, DIAMETER, DIAMETER);
            //                gc.fillArc(x * 40, y * 40, DIAMETER, DIAMETER, 0, 360, ArcType.ROUND);
            gc.setFill(Color.BLACK);
        }
        gc.fillText(step.toString(), x * 40 + 10, y * 40 + 30);
    }

    private static Service service;
    private static List<Chess> chessList;

    public static void replay(Board board, GraphicsContext gc, Canvas draw) {
        if (!flag) {
            flag = true;
            return;
        }
        chessList = board.getChessList();
        i = 0;

        service = new Service() {
            long time = chessList.get(i).getTime();

            @Override protected Task<Void> createTask() {
                return new Task<>() {
                    @Override protected Void call() throws Exception {
                        for (i = 0; i < chessList.size(); i++) {
                            if (flag) {
                                Chess chess = chessList.get(i);
                                if (flag && chess.getStep() > 1) {
                                    try {
                                        Thread.sleep(chess.getTime() - time);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                time = chess.getTime();
                                drawChess(chess.getStep(), chess.getColor(), chess.getX(), chess.getY(), gc, draw);
                            } else {
                                wait();
                            }
                        }
                        return null;
                    }
                };
            }
        };
        service.start();
    }

    public static void front(GraphicsContext gc, Canvas draw) throws InterruptedException {
        stop();
        int tmp = 0;
        while (i < chessList.size()) {
            if (i < 0) {
                i = 0;
            }
            Chess chess = chessList.get(i++);
            drawChess(chess.getStep(), chess.getColor(), chess.getX(), chess.getY(), gc, draw);
            if (++tmp == 5) {
                break;
            }
        }
        flag = true;
    }

    public static void stop() throws InterruptedException {
        //        service.cancel();
        flag = false;

    }

    public static void back(GraphicsContext gc, Canvas draw) throws InterruptedException {
        stop();
        int tmp = 0;
        i--;
        while (i >= 0) {
            Chess chess = chessList.get(i--);
            gc.clearRect(chess.getX() * 40, chess.getY() * 40, DIAMETER, DIAMETER);
            if (++tmp == 5) {
                break;
            }
        }
        i++;
        flag = true;
        //        service.notify();
    }

    public static Board getSelectedBoard(TableView<BoardReplayTable> table) {

        BoardReplayTable boardReplayTable = table.getSelectionModel().getSelectedItem();
        List<Board> boards = BoardController.getSingleton().getBoards();
        Board board = null;
        for (Board b : boards) {
            if (Tools.millsToString(b.getTime()).equals(boardReplayTable.getTime())) {
                board = b;
                break;
            }
        }
        return board;
    }

    public static void draw(Board board, GraphicsContext gc, Canvas draw) {
        List<Chess> chessList = board.getChessList();
        for (Chess chess : chessList) {
            FXTools.drawChess(chess.getStep(), chess.getColor(), chess.getX(), chess.getY(), gc, draw);
        }
    }
}

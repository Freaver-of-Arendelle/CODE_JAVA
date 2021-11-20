package com.example.goBangFx.view.controller;

import cn.hutool.core.util.ReUtil;
import com.example.goBangFx.controller.BoardController;
import com.example.goBangFx.model.bean.Board;
import com.example.goBangFx.model.bean.Chess;
import com.example.goBangFx.view.AppModel;
import com.example.goBangFx.view.ReplayApp;
import com.example.goBangFx.view.utils.Tools;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.*;

/**
 * @author Freaver
 */
public class GoBangController implements Initializable{

    @FXML private Pane root;

    @FXML private TextField userText;

    @FXML private Canvas draw;

    @FXML private Button giveUpBtn;

    @FXML private Button pullBackBtn;

    @FXML private Button replayBtn;

    @FXML private Button saveBtn;
    @FXML private TextField winText;

    private int color = 1;
    private GraphicsContext gc;
    private Integer step = 1;
    private final int DIAMETER = 40;
    private int preX;
    private int preY;
    private String userName;
    public Board board = new Board();

    private static AppModel model = new AppModel();

    @FXML void giveUpAction(ActionEvent event) {
        board.setWinner(color);
        win();
    }



    @FXML void handleCanvasClicked(MouseEvent e) {

        int pointX = (int)e.getX();
        int pointY = (int)e.getY();
        //System.out.println(pointX+" "+pointY);
        int statusX = 0;
        int statusY = 0;
        if (pointX >= -20 && pointX <= 620 && pointY >= -20 && pointY <= 620) {
            for (int i = 0; i < 16; i++) {
                if (pointX >= i * 40 && pointX < i * 40 + 40) {
                    statusX = i;
                }
                if (pointY >= i * 40 && pointY < i * 40 + 40) {
                    statusY = i;
                }
            }
            //System.out.println(statusX+" "+statusY);
            drawChess(statusX, statusY);
        }
    }

    public static void setBoard(Board board) {
        model.setBoard(board);
    }

    public void setUserName(String userName) {
        BoardController.getSingleton().setUserName(userName);
        this.userName = userName;
        userText.setText(userName);
        board.setUserName(userName);
    }

    private void drawChess(int x, int y) {
        gc = draw.getGraphicsContext2D();
        if (board.getVis()[x][y] == 0) {
            preX = x;
            preY = y;
            Chess chess = new Chess(x, y, step, color);
            board.addChess(chess);
            board.getVis()[x][y] = color;
            gc.setFont(Font.font(30));
            if (color == 1) {
                gc.setFill(Color.BLACK);

                gc.fillOval(x * 40, y * 40, DIAMETER, DIAMETER);
                //                gc.fillArc(x * 40, y * 40, DIAMETER, DIAMETER, 0, 360, ArcType.ROUND);
                gc.setFill(Color.WHITE);
                gc.fillText(step.toString(), x * 40 + 10, y * 40 + 30);
            } else {
                gc.setFill(Color.WHITE);
                gc.fillOval(x * 40, y * 40, DIAMETER, DIAMETER);
                //                gc.fillArc(x * 40, y * 40, DIAMETER, DIAMETER, 0, 360, ArcType.ROUND);
                gc.setFill(Color.BLACK);
                gc.fillText(step.toString(), x * 40 + 10, y * 40 + 30);
            }
            color %= 2;
            color += 1;
            step++;
            win();
        }
    }

    private void win() {
        if (board.isWin()) {
            color %= 2;
            color += 1;
            board.setWinner(color);
            String winner = null;
            if (color == 1) {
                winner = "黑";
            } else if (color == 2) {
                winner = "白";
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(new Button(winner + "赢"), 100, 100));
            winText.setText(winner);
            stage.show();
        }
    }

    @FXML void pullBackAction(ActionEvent event) {
        gc.clearRect(preX * 40, preY * 40, DIAMETER, DIAMETER);
        board.removeChess(preX, preY);
        color %= 2;
        color += 1;
    }

    @FXML void replayAction(ActionEvent event) throws Exception {
        ReplayApp app = new ReplayApp();
//        Tools.init(replayBtn, app);
        app.start(new Stage());
        app.setUserName(userName);

    }

    @FXML void saveAction(ActionEvent event) {
        BoardController controller = BoardController.getSingleton().setUserName(userName);
        controller.addBoard(board);
        Stage stage = new Stage();
        stage.setScene(new Scene(new Button("保存成功"), 100, 100));
        stage.show();
    }

    public void replay(Board board) {
        List<Chess> chessList = board.getChessList();

        Service service = new Service() {
            long time = chessList.get(0).getTime();

            @Override protected Task<Void> createTask() {
                return new Task<>() {
                    @Override protected Void call() throws Exception {
                        for (Chess chess : chessList) {
                            if (chess.getStep() > 1) {
                                try {
                                    Thread.sleep(chess.getTime() - time);
                                    time = chess.getTime();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            drawChess(chess.getX(), chess.getY());
                        }
                        return null;
                    }
                };
            }
        };

        service.start();
    }



    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
//        model.boardProperty().addListener((obs, oldBoard, newBoard) -> board = newBoard);
    }
}

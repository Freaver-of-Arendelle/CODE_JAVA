package com.freaver.goBang2.view.controller;

import com.freaver.goBang2.controller.BoardController;
import com.freaver.goBang2.model.bean.Board;
import com.freaver.goBang2.model.bean.Chess;
import com.freaver.goBang2.view.AppModel;
import com.freaver.goBang2.view.ReplayListApp;
import com.freaver.goBang2.view.SearchApp;
import com.freaver.goBang2.view.utils.FXTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Freaver
 */
public class GoBangController implements Initializable {
    @FXML private Button beginBtn;

    @FXML private TextField blackText;

    @FXML private Button continueBtn;

    @FXML private Canvas draw;

    @FXML private Button exitBtn;

    @FXML private Button pullBackBtn;

    @FXML private Button replayBtn;

    @FXML private Pane root;

    @FXML private Button saveBtn;

    @FXML private TextField whiteText;

    @FXML private Button searchBtn;

    private int color = 1;
    private GraphicsContext gc;
    private Integer step = 1;
    private final int DIAMETER = 40;
    private int preX;
    private int preY;
    private String blackName;
    private String whiteName;
    private boolean isBegin = false;
    public Board board = new Board();

    private static final AppModel MODEL = new AppModel();

    @FXML
    void beginAction(ActionEvent event) {
        isBegin = true;
    }

    @FXML
    void continueAction(ActionEvent event) throws Exception {
        FXTools.start(new ReplayListApp());
    }

    @FXML
    void exitAction(ActionEvent event) {
        FXTools.exit(exitBtn);
    }

    @FXML void handleCanvasClicked(MouseEvent e) {
        if (isBegin) {
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
    }

    public static void setBoard(Board board) {
        MODEL.setBoard(board);
    }

    public void setName(String blackName, String whiteName) {
        BoardController.getSingleton().setName(blackName, whiteName);
        this.blackName = blackName;
        this.whiteName = whiteName;
        blackText.setText(blackName);
        whiteText.setText(whiteName);
        board.setName(blackName, whiteName);
    }

    private void drawChess(int x, int y) {
        gc = draw.getGraphicsContext2D();
        if (board.getVis()[x][y] == 0) {
            preX = x;
            preY = y;
            FXTools.drawChess(step, color, x, y, gc, draw);
            Chess chess = new Chess(x, y, step, color);
            board.addChess(chess);
            board.getVis()[x][y] = color;
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
        //        Tools.init(replayBtn, app);
        FXTools.start(new ReplayListApp());

    }

    @FXML void saveAction(ActionEvent event) {

        blackName = blackText.getText();
        whiteName = whiteText.getText();
        BoardController controller = BoardController.getSingleton();
        controller.setName(blackName, whiteName);
        board.setName(blackName, whiteName);
        controller.addBoard(board);
        Stage stage = new Stage();
        stage.setScene(new Scene(new Button("保存成功"), 100, 100));
        stage.show();
    }

    public void replay(Board board) {
        FXTools.replay(board, gc, draw);
//        List<Chess> chessList = board.getChessList();

//        Service service = new Service() {
//            long time = chessList.get(0).getTime();

//            @Override protected Task<Void> createTask() {
//                return new Task<>() {
//                    @Override protected Void call() throws Exception {
//                        for (Chess chess : chessList) {
//                            if (chess.getStep() > 1) {
//                                try {
//                                    Thread.sleep(chess.getTime() - time);
//                                    time = chess.getTime();
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                            drawChess(chess.getX(), chess.getY());
//                        }
//                        return null;
//                    }
//                };
//            }
//        };
//        service.start();
        isBegin = false;
    }

    public void continueBoard(Board board) {
        this.board = board;
        FXTools.draw(board, gc, draw);
        step = board.getChessList().size() + 1;
        if (step % 2 == 0) {
            color = 0;
        } else {
            color = 1;
        }
        isBegin = true;
    }

    @Override public void initialize(URL url, ResourceBundle resourceBundle) {
        //        model.boardProperty().addListener((obs, oldBoard, newBoard) -> board = newBoard);
    }

    @FXML public void searchAction(ActionEvent e) throws Exception {
        FXTools.init(searchBtn, new SearchApp());

    }
}

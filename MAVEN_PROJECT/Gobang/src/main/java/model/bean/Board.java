package model.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 */
public class Board {
    private int[][] vis;

    private static int[][] dir = {{-1, 0}, {-1, -1}, {0, 1}, {1, 1}};

    private List<Chess> chessList;

    public Board() {
        chessList = new ArrayList<>();
        vis = new int[16][16];
    }

    private boolean tmpJudge(int color, int dir, int i, int j) {
        boolean flag = true;
        if (flag) {
            for (int l = -2; l < 3; l++) {
                int x = i + dir * l, y = j + dir * l;
                if (vis[x][y] == color) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean isWin() {
        for (int i = 2; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                for (int k = 0; k < 4; k++) {
                    if (tmpJudge(2, dir[i][j], i, j) || tmpJudge(1, dir[i][j], i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addChess(Chess chess) {
        chessList.add(chess);
        vis[chess.getX()][chess.getY()] = chess.getColor();
    }

    public int[][] getVis() {
        return vis;
    }
}

package com.example.goBangFx.model.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Board implements Serializable {
    private int vis[][] = new int[16][16];
    private String userName;
    private List<Chess> chessList;
    private int winner; // 0.blank, 1.black , 2.white
    private Long time;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Board(List<Chess> chessList, int winner) {
        this.chessList = chessList;
        this.winner = winner;
        time = System.currentTimeMillis();
    }

    public Board() {
        chessList = new ArrayList<>();
        time = System.currentTimeMillis();
    }

    private static int[][] dir = {{-1, 0}, {-1, -1}, {0, 1}, {-1, 1}};

    private boolean isValid(int x, int y) {
        return x > -1 && x < 16 && y > -1 && y < 16;
    }

    private boolean tmpJudge(int color, int dirX, int dirY, int i, int j) {
        int tmp = 0;
        for (int l = -2; l < 3; l++) {
            int x = i + dirX * l, y = j + dirY * l;
            if (!isValid(x, y)) {
                return false;
            }
            if (vis[x][y] == color) {
                tmp++;
            }
        }
        return tmp == 5;
    }

    public Long getTime() {
        return time;
    }

    public boolean isWin() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                for (int k = 0; k < 4; k++) {
                    if (tmpJudge(2, dir[k][0], dir[k][1], i, j) || tmpJudge(1, dir[k][0], dir[k][1], i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int[][] getVis() {
        return vis;
    }

    public void addChess(Chess chess) {
        chessList.add(chess);
    }

    public void removeChess(int x, int y) {
        chessList.removeIf(e -> e.getX().equals(x) && e.getY().equals(y));
        vis[x][y] = 0;

    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public List<Chess> getChessList() {
        return chessList;
    }

    public int getWinner() {
        return winner;
    }
}

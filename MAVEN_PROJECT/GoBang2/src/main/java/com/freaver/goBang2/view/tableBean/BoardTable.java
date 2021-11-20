package com.freaver.goBang2.view.tableBean;

/**
 * @author Freaver
 * @date 10/17/2021
 * @time 00:34
 */
@Deprecated
public class BoardTable {
    private String time;
    private String winner;

    public BoardTable(String time, String winner) {
        this.time = time;
        this.winner = winner;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
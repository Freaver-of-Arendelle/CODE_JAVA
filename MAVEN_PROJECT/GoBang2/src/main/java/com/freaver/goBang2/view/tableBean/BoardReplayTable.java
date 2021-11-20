package com.freaver.goBang2.view.tableBean;

/**
 * @author Freaver
 * @date 10/17/2021
 * @time 00:34
 */
public class BoardReplayTable {
    private String winner;
    private String blackName;
    private String whiteName;
    private String time;

    public BoardReplayTable(String winner, String blackName, String whiteName, String time) {
        this.winner = winner;
        this.blackName = blackName;
        this.whiteName = whiteName;
        this.time = time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getBlackName() {
        return blackName;
    }

    public void setBlackName(String blackName) {
        this.blackName = blackName;
    }

    public String getWhiteName() {
        return whiteName;
    }

    public void setWhiteName(String whiteName) {
        this.whiteName = whiteName;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
package com.freaver.goBang2.model.bean;

import java.io.Serializable;

public class Chess implements Serializable {
    private Long time;
    private Integer x;
    private Integer y;
    private Integer step;
    private int color; // 0 blank; 1 black; 2 white

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Chess(Integer x, Integer y, Integer step, int color) {
        this.time = System.currentTimeMillis();
        this.x = x;
        this.y = y;
        this.step = step;
        this.color = color;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }
}

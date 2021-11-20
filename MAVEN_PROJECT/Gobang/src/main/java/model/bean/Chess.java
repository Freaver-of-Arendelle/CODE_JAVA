package model.bean;

public class Chess {
    private Long time;
    private Integer x;
    private Integer y;
    private Integer step;
    private int color; // 0 blank; 1 while 2; black

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Chess(Integer x, Integer y, Integer step) {
        this.time = System.currentTimeMillis();
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public long getTime() {
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

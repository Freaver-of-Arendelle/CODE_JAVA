package pattern.structural.decorator;

/**
 * @author Freaver
 * @date 4/25/2021 23:28
 */
public abstract class FastFood {
    private float price;
    private String desc;

    public FastFood() {

    }

    public FastFood(float price, String desc) {
        this.desc = desc;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract float cost();


}

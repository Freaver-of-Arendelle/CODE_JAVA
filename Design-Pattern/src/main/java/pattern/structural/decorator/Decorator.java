package pattern.structural.decorator;

/**
 * @author Freaver
 * @date 4/25/2021 23:33
 */
public abstract class Decorator extends FastFood {

    private FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Decorator(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

}

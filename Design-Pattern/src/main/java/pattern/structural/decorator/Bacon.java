package pattern.structural.decorator;

/**
 * @author Freaver
 * @date 4/25/2021 23:35
 */
public class Bacon extends Decorator {

    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "Bacon");
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().getPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}

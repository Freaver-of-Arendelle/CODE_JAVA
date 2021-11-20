package pattern.structural.decorator;

/**
 * @author Freaver
 * @date 4/25/2021 23:35
 */
public class Egg extends Decorator {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "Egg");
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

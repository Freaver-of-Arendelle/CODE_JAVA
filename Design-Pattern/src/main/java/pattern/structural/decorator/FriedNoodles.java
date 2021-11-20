package pattern.structural.decorator;

/**
 * @author Freaver
 * @date 4/25/2021 23:30
 */
public class FriedNoodles extends FastFood{

    public FriedNoodles() {
        super(12, "FriedNoodles");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}

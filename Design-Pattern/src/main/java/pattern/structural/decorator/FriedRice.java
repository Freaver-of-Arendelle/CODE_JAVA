package pattern.structural.decorator;

/**
 * @author Freaver
 * @date 4/25/2021 23:30
 */
public class FriedRice extends FastFood {

    public FriedRice() {
        super(10, "FriedRice");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}

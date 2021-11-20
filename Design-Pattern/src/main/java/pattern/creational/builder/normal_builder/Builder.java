package pattern.creational.builder.normal_builder;

/**
 * @author Freaver
 * @date 4/28/2021 22:49
 */
public abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public Bike createBike() {
        return bike;
    }
}

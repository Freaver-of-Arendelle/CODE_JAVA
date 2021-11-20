package pattern.creational.builder.normal_builder;

/**
 * @author Freaver
 * @date 4/28/2021 22:50
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}

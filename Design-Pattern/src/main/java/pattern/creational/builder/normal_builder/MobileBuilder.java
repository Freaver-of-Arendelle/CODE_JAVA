package pattern.creational.builder.normal_builder;

/**
 * @author Freaver
 * @date 4/28/2021 22:51
 */
public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Carbon Frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather Seat");
    }


}

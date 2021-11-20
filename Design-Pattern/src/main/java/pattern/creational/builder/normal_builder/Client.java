package pattern.creational.builder.normal_builder;

/**
 * @author Freaver
 * @date 4/28/2021 22:54
 */
public class Client {
    public static void main(String[] args) {

        Director director = new Director(new MobileBuilder());

        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}

package pattern.creational.factory.simple_factory;

/**
 * @author Freaver
 * @date 4/28/2021 17:42
 */
public class SimpleCoffeeFactory {


    public Coffee createCoffee(String type) {
        Coffee coffee = null;

        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("Sorry, there is no coffee you ordered");
        }

        return coffee;
    }
}

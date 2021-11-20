package pattern.creational.factory.factory_method;

/**
 * @author Freaver
 * @date 4/28/2021 18:12
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}

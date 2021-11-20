package pattern.creational.factory.simple_factory;

/**
 * @author Freaver
 * @date 4/28/2021 17:46
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();

        Coffee coffee = factory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;

    }
}

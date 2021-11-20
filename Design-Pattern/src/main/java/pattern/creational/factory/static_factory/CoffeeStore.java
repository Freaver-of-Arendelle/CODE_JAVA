package pattern.creational.factory.static_factory;

/**
 * @author Freaver
 * @date 4/28/2021 17:51
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {

        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

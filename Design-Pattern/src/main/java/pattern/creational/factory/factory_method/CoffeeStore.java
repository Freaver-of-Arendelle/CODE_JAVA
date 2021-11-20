package pattern.creational.factory.factory_method;

/**
 * @author Freaver
 * @date 4/28/2021 18:17
 */
public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

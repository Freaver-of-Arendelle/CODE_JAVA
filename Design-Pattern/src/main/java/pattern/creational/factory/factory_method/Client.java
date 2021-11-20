package pattern.creational.factory.factory_method;

/**
 * @author Freaver
 * @date 4/28/2021 18:18
 */
public class Client {

    public static void main(String[] args) {

        CoffeeStore store = new CoffeeStore();

        CoffeeFactory factory = new LatteCoffeeFactory();

        store.setFactory(factory);

        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }
}

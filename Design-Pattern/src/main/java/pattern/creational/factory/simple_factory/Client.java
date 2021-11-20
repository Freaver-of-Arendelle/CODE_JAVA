package pattern.creational.factory.simple_factory;

/**
 * @author Freaver
 * @date 4/28/2021 17:46
 */
public class Client {

    public static void main(String[] args) {

        CoffeeStore store = new CoffeeStore();

        Coffee coffee = store.orderCoffee("Latte");

        System.out.println(coffee.getName());
    }
}

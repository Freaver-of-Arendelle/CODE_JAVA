package pattern.creational.factory.config_factory;

/**
 * @author Freaver
 * @date 4/28/2021 18:04
 */
public class Client {

    public static void main(String[] args) {

        Coffee coffee = CoffeeFactory.createCoffee("American");

        System.out.println(coffee.getName());

        System.out.println("=============================");

        Coffee coffee1 = CoffeeFactory.createCoffee("Latte");

        System.out.println(coffee1.getName());
    }
}

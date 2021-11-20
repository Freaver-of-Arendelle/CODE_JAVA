package pattern.creational.factory.before;

/**
 * @author Freaver
 * @date 4/28/2021 17:37
 */
public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();

        Coffee coffee = coffeeStore.orderCoffee("American");

        System.out.println(coffee.getName());
    }
}

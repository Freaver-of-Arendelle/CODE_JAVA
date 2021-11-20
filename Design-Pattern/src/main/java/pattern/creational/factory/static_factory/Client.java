package pattern.creational.factory.static_factory;

/**
 * @author Freaver
 * @date 4/28/2021 17:52
 */
public class Client {
    public static void main(String[] args) {
        //创建咖啡店类对象
        CoffeeStore store = new CoffeeStore();
        Coffee coffee = store.orderCoffee("Latte");

        System.out.println(coffee.getName());
    }
}
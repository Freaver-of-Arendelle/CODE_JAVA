package pattern.creational.factory.abstract_factory;

/**
 * @author Freaver
 * @date 4/28/2021 18:26
 */
public class Client {

    public static void main(String[] args) {
        AmericanDessertFactory factory = new AmericanDessertFactory();

        Coffee coffee = factory.createCoffee();

        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());

        dessert.show();
    }
}

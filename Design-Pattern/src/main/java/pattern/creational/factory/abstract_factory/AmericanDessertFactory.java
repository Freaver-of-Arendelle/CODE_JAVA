package pattern.creational.factory.abstract_factory;

/**
 * @author Freaver
 * @date 4/28/2021 18:25
 */
public class AmericanDessertFactory {

    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    public Dessert createDessert() {
        return new MatchMousse();
    }
}

package pattern.creational.factory.abstract_factory;

/**
 * @author Freaver
 * @date 4/28/2021 18:25
 */
public class ItalyDessertFactory {

    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    public Dessert createDessert() {
        return new Tiramisu();
    }
}

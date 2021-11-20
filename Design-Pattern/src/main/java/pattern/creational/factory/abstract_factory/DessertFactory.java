package pattern.creational.factory.abstract_factory;


/**
 * @author Freaver
 * @date 4/28/2021 18:21
 */
public interface DessertFactory {

    Coffee createCoffee();

    Dessert createDessert();
}

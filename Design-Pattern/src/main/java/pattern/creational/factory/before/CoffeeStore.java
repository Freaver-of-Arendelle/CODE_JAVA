package pattern.creational.factory.before;

/**
 * @author Freaver
 * @date 4/28/2021 17:32
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        Coffee coffee = null;

        if ("American".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("Latte".equals(type)) {
            coffee = new LatteCoffee();
        } else  {
            throw new RuntimeException("Sorry, there is no coffee you ordered");
        }

        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}

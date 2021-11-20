package pattern.creational.factory.static_factory;

/**
 * @author Freaver
 * @date 4/28/2021 17:26
 */
public abstract class Coffee {
    public abstract String getName();

    public void addSugar() {
        System.out.println("addSugar");
    }

    public void addMilk() {
        System.out.println("addMilk");
    }
}

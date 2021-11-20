package pattern.behavioral.visitor.dispatch.dynamic_dispatch;

/**
 * @author Freaver
 * @date 5/2/2021 00:31
 */
public class Client {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.execute();

        Cat cat = new Cat();
        cat.execute();
    }
}

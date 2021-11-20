package pattern.behavioral.visitor.dispatch.double_dispatch;

/**
 * @author Freaver
 * @date 5/2/2021 00:39
 */
public class Client {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        Execute execute = new Execute();
        animal.accept(execute);
        animal1.accept(execute);
        animal2.accept(execute);
    }
}

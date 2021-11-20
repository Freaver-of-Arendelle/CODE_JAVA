package pattern.behavioral.visitor.dispatch.static_dispatch;

/**
 * @author Freaver
 * @date 5/2/2021 00:35
 */
public class Client {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        Execute execute = new Execute();
        execute.execute(animal);
        execute.execute(dog);
        execute.execute(cat);
    }
}

package pattern.behavioral.visitor.demo;

/**
 * @author Freaver
 * @date 5/2/2021 00:24
 */
public class Someone implements Person{
    @Override
    public void feed(Cat cat) {
        System.out.println("Someone Feed cat");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("Someone Feed dog");

    }
}

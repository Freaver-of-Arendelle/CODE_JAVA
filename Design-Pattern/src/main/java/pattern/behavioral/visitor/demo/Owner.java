package pattern.behavioral.visitor.demo;

/**
 * @author Freaver
 * @date 5/2/2021 00:24
 */
public class Owner implements Person{
    @Override
    public void feed(Cat cat) {
        System.out.println("Owner Feed cat");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("Owner Feed dog");

    }
}

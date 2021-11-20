package pattern.behavioral.visitor.demo;

/**
 * @author Freaver
 * @date 5/2/2021 00:24
 */
public interface Person {
    void feed(Cat cat);

    void feed(Dog dog);
}

package pattern.behavioral.mediator;

/**
 * @author Freaver
 * @date 5/1/2021 22:08
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }


}

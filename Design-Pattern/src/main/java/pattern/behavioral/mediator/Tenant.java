package pattern.behavioral.mediator;

/**
 * @author Freaver
 * @date 5/1/2021 22:12
 */
public class Tenant extends Person{
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void contact(String message) {
        mediator.contact(message, this);
    }

    public void getMessage(String message) {
        System.out.println("Tenant: " + name + "Message: " + message);
    }
}

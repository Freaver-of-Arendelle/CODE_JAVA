package pattern.behavioral.mediator;

/**
 * @author Freaver
 * @date 5/1/2021 22:10
 */
public class HouseOwner extends Person{
    public HouseOwner(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void contact(String message) {
        mediator.contact(message, this);
    }

    public void getMessage(String message) {
        System.out.println("HouseOwner: " + name + "Message: " + message);
    }
}

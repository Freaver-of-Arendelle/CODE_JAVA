package pattern.behavioral.visitor.dispatch.double_dispatch;

/**
 * @author Freaver
 * @date 5/2/2021 00:38
 */
public class Execute {
    public void execute(Animal animal) {
        System.out.println("Animal");
    }
    public void execute(Dog dog) {
        System.out.println("Dog");
    }
    public void execute(Cat cat) {
        System.out.println("Cat");
    }
}

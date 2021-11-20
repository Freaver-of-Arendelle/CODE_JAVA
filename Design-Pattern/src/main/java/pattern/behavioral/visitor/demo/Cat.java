package pattern.behavioral.visitor.demo;

/**
 * @author Freaver
 * @date 5/2/2021 00:26
 */
public class Cat implements Animal{
    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("Miao");
    }
}

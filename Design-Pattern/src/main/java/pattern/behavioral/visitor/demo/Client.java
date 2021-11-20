package pattern.behavioral.visitor.demo;

/**
 * @author Freaver
 * @date 5/2/2021 00:28
 */
public class Client {
    public static void main(String[] args) {
        Home home = new Home();
        home.add(new Dog());
        home.add(new Cat());

        home.action(new Owner());

        home.action(new Someone());
    }
}

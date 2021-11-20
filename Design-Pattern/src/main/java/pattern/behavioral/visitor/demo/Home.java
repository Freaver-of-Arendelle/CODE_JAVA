package pattern.behavioral.visitor.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 5/2/2021 00:27
 */
public class Home {

    private List<Animal> list = new ArrayList<>();

    public void action(Person person) {
        for (Animal animal : list) {
            animal.accept(person);
        }
    }

    public void add(Animal animal) {
        list.add(animal);
    }
}

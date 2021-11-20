package pattern.behavioral.observer.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 5/1/2021 09:41
 */
public class SubscriptionSubject implements Subject{

    private List<Observer> list = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {

        list.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : list) {
            observer.update(message);

        }
    }
}

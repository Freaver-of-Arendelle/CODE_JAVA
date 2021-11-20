package pattern.behavioral.observer.demo;

/**
 * @author Freaver
 * @date 5/1/2021 09:39
 */
public interface Subject {
    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notify(String message);
}

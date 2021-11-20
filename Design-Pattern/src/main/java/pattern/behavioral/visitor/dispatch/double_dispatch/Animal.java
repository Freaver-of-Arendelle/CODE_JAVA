package pattern.behavioral.visitor.dispatch.double_dispatch;

/**
 * @author Freaver
 * @date 5/2/2021 00:37
 */
public class Animal {
    public void accept(Execute e) {
        e.execute(this);
    }
}

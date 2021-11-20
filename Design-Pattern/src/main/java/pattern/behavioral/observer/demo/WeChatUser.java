package pattern.behavioral.observer.demo;

/**
 * @author Freaver
 * @date 5/1/2021 09:38
 */
public class WeChatUser implements Observer{

    private String name;

    public WeChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }


}

package pattern.behavioral.observer.demo;

/**
 * @author Freaver
 * @date 5/1/2021 09:43
 */
public class Client {

    public static void main(String[] args) {

        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();

        WeChatUser user = new WeChatUser("Sun");
        WeChatUser user1 = new WeChatUser("Zhu");
        WeChatUser user2 = new WeChatUser("Sha");

        subscriptionSubject.attach(user);
        subscriptionSubject.attach(user1);
        subscriptionSubject.attach(user2);

        subscriptionSubject.notify("It's update now.");


    }
}

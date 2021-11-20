package pattern.structural.proxy.JDKProxy;

/**
 * @author Freaver
 * @date 4/25/2021 15:28
 */
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();

        SellTickets proxyObject = factory.getProxyObject();

        proxyObject.sell();
    }
}

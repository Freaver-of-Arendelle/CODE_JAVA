package pattern.structural.proxy.StaticProxy;

/**
 * @author Freaver
 * @date 4/25/2021 20:54
 */
public class Client {
    public static void main(String[] args) {
        ProxyPoint pp = new ProxyPoint();
        pp.sell();
    }
}

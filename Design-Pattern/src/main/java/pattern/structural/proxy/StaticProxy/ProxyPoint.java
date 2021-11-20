package pattern.structural.proxy.StaticProxy;

/**
 * @author Freaver
 * @date 4/25/2021 20:52
 */
public class ProxyPoint implements SellTickets{

    private TrainStation station = new TrainStation();
    @Override
    public void sell() {
        System.out.println("Proxy take some service money");
        station.sell();
    }
}

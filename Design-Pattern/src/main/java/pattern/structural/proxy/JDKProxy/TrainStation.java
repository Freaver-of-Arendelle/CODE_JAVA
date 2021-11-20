package pattern.structural.proxy.JDKProxy;

public class TrainStation implements SellTickets{
    @Override
    public void sell() {
        System.out.println("Proxy.CGLIBProxy.TrainStation selling");
    }
}

package pattern.structural.proxy.StaticProxy;

/**
 * @author Freaver
 * @date 4/25/2021 20:52
 */
public class TrainStation implements SellTickets{
    @Override
    public void sell() {
        System.out.println("TrainStation selling");
    }
}

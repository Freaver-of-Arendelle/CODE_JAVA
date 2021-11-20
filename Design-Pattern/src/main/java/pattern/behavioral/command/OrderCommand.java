package pattern.behavioral.command;

import java.util.Map;
import java.util.Set;

/**
 * @author Freaver
 * @date 4/29/2021 20:52
 */
public class OrderCommand implements Command {

    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "Table's order");
        Map<String, Integer> foodDir = order.getFoodDir();

        Set<String> keys = foodDir.keySet();

        for (String foodName : keys) {
            receiver.makeFood(foodName, foodDir.get(foodName));
        }

        System.out.println(order.getDiningTable() + "table's order is already");
    }
}

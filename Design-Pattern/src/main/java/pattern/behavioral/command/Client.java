package pattern.behavioral.command;

/**
 * @author Freaver
 * @date 4/29/2021 20:54
 */
public class Client {

    public static void main(String[] args) {
        
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("西红柿鸡蛋面",1);
        order1.setFood("小杯可乐",2);

        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("尖椒肉丝盖饭",1);
        order2.setFood("小杯雪碧",2);


        SeniorChef receiver = new SeniorChef();

        OrderCommand cmd1 = new OrderCommand(receiver, order1);
        OrderCommand cmd2 = new OrderCommand(receiver, order2);

        Waiter invoke = new Waiter();

        invoke.setCommand(cmd1);
        invoke.setCommand(cmd2);

        invoke.orderUp();



    }
}

package pattern.behavioral.strategy;

/**
 * @author Freaver
 * @date 4/29/2021 20:43
 */
public class Client {

    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan(new StragtegyA());

        salesMan.show();

        System.out.println("==========================");

        salesMan.setStrategy(new StragtegyB());

        salesMan.show();

        System.out.println("==========================");

        salesMan.setStrategy(new StragtegyC());

        salesMan.show();
    }
}

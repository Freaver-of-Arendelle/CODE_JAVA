package pattern.behavioral.state.before;

/**
 * @author Freaver
 * @date 4/30/2021 23:54
 */
public class Client {
    public static void main(String[] args) {
        Lift lift = new Lift();

        lift.setState(Ilift.CLOSING_STATE);

        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}

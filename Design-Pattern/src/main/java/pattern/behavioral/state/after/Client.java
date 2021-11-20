package pattern.behavioral.state.after;

/**
 * @author Freaver
 * @date 5/1/2021 00:10
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());

        context.open();
        context.close();
        context.run();
        context.stop();
    }
}

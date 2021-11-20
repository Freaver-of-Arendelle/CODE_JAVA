package pattern.behavioral.state.before;

/**
 * @author Freaver
 * @date 4/30/2021 23:27
 */
public interface Ilift {
    public final static int OPENING_STATE = 1;

    public final static int CLOSING_STATE = 2;

    public final static int RUNNING_STATE = 3;

    public final static int STOPPING_STATE = 4;

    public void setState(int state);

    public void open();

    public void close();

    public void run();

    public void stop();


}

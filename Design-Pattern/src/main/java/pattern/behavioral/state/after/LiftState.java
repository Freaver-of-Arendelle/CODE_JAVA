package pattern.behavioral.state.after;

/**
 * @author Freaver
 * @date 4/30/2021 23:55
 */
public abstract class LiftState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();


}

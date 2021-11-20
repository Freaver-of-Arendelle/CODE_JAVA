package pattern.behavioral.responsibility.demo;

/**
 * @author Freaver
 * @date 4/30/2021 12:46
 */
public abstract class Handler {

    protected final static int NUM_GROUP = 1;
    protected final static int NUM_MANAGER = 3;
    protected final static int NUM_GENERAL = 7;

    private int numStart;
    private int numEnd;

    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void handleLeave(LeaveRequest leaveRequest);


    public final void submit(LeaveRequest leaveRequest) {
        if (this.numStart == 0) {
            return;
        }

        if (leaveRequest.getNum() > this.numStart) {
            this.handleLeave(leaveRequest);

            if (this.nextHandler != null && leaveRequest.getNum() > numEnd) {
                this.nextHandler.submit(leaveRequest);
            } else {
                System.out.println("Over");
            }
        }
    }
}
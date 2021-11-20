package pattern.behavioral.responsibility.demo;

/**
 * @author Freaver
 * @date 4/30/2021 12:53
 */
public class GeneralManager extends Handler{

   public GeneralManager() {
       super(Handler.NUM_GENERAL);
   }

    @Override
    protected void handleLeave(LeaveRequest leaveRequest) {

        System.out.println(leaveRequest.getName() + "Reset" + leaveRequest.getNum() +
                "day, " + leaveRequest.getContent() );
        System.out.println("GeneralManager: Agree");
    }
}

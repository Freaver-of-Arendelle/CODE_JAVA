package pattern.behavioral.responsibility.demo;

/**
 * @author Freaver
 * @date 4/30/2021 12:53
 */
public class GroupLeader extends Handler{

   public GroupLeader() {
       super(Handler.NUM_GROUP, Handler.NUM_MANAGER);
   }

    @Override
    protected void handleLeave(LeaveRequest leaveRequest) {

        System.out.println(leaveRequest.getName() + "Reset" + leaveRequest.getNum() +
                "day, " + leaveRequest.getContent() );
        System.out.println("GroupLeader: Agree");
    }
}

package pattern.behavioral.responsibility.demo;

/**
 * @author Freaver
 * @date 4/30/2021 12:57
 */
public class Client {

    public static void main(String[] args) {
        LeaveRequest leaveRequest = new LeaveRequest("Li", 8, "Body uncomfortable");

        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(leaveRequest);


    }
}

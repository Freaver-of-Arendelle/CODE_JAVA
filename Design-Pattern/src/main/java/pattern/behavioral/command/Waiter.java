package pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 * @date 4/29/2021 20:46
 */
public class Waiter {

    public List<Command> commands = new ArrayList<>();

    public void setCommand(Command command) {
        this.commands.add(command);
    }

    public void orderUp() {
        System.out.println("New order is coming...");

        for (Command command : commands) {
            if (command != null) {
                command.execute();
            }

        }
    }

}

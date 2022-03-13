package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class CommandQueue {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

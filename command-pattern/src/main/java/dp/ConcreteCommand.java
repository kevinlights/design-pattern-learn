package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class ConcreteCommand extends Command {
    private Receiver receiver;

    @Override
    public void execute() {
        receiver.action();
    }
}

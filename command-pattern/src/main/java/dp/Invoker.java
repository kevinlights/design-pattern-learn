package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    // 业务方法
    public void call() {
        command.execute();
    }
}

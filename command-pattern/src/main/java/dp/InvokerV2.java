package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class InvokerV2 {
    private CommandQueue commandQueue;

    public void setCommandQueue(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public InvokerV2(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void call() {
        commandQueue.execute();
    }
}

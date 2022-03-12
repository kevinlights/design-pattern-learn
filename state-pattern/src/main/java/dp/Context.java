package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class Context {
    private State state;
    private int value;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle();
    }
}

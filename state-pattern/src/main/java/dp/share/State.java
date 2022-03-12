package dp.share;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public abstract class State {
    abstract void on(Switch s);
    abstract void off(Switch s);
}

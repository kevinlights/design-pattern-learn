package dp.share;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class Switch {
    // 用静态变量来在不同对象（开关）之间共享状态
    private static State state, onState, offState;
    private String name;

    public Switch(String name) {
        this.name = name;
        this.onState = new OnState();
        this.offState = new OffState();

        this.state = onState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static State getState(String type) {
        if (type.equalsIgnoreCase("on")) {
            return onState;
        } else {
            return offState;
        }
    }

    public void on() {
        System.out.print(name);
        state.on(this);
    }

    public void off() {
        System.out.print(name);
        state.off(this);
    }
}

package dp;

/**
 * created on 2022/3/12
 * 原发器，可以创建一个备忘录，并存储它的当前内部状态
 * 也可以使用备忘录来恢复其内部状态
 *
 * 具体的业务类
 * @author kevinlights
 */
public class Originator {
    private String state;

    public Originator() {
    }

    public void restoreMemento(Memento m) {
        state = m.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

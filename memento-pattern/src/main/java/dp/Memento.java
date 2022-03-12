package dp;

/**
 * created on 2022/3/12
 * 存储原发器的内部状态，根据原发器来决定保存哪些内部状态
 *
 * 提供与原发器相对应的属性（全部或部分）
 * @author kevinlights
 */
public class Memento {
    private String state;

    public Memento(Originator o) {
        state = o.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

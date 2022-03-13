package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class Adapter extends Target {
    private Adaptee adaptee; // 引用适配者对象

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

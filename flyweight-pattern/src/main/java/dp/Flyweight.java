package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public abstract class Flyweight {
    // 内在状态，同一个享元对象其内部状态是一致的
    private String intrinsicState;

    public Flyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    // 外部状态在使用时由外部设置，不保存在享元对象中
    // 即使是同一个对象中，在每一次调用时也可以传入不同的外部状态
    public void operation(String extrinsicState) {

    }
}

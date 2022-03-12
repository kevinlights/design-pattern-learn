package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    // 处理同事方法 Self-Method
    public abstract void method1();

    // Depend-Method
    public void method2() {
        // 调用中介者方法
        mediator.operation();
    }
}

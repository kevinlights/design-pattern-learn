package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void operation() {
        // 业务方法，可调不同的同事类方法
        colleagues.get(0).method1();
    }
}

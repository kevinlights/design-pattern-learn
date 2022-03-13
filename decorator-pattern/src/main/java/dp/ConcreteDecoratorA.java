package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation(); // 调用原有业务方法
        addedBehavior(); // 调用新增业务方法
    }

    public void addedBehavior() {

    }
}

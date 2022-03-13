package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class Decorator implements Component {
    private Component component; // 引用抽象构件对象

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation(); // 调用原有的业务方法
    }
}

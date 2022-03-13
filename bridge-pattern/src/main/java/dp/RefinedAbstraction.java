package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class RefinedAbstraction extends Abstraction {
    @Override
    public void operation() {
        impl.operationImpl();
    }
}

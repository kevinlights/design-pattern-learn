package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class ConcreteElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {

    }
}

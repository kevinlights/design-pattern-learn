package sample;

/**
 * created on 2022/3/12
 * AND 解释，非终结表达式
 * @author kevinlights
 */
public class AndNode extends AbstractNode{
    private AbstractNode left;
    private AbstractNode right;

    public AndNode(AbstractNode left, AbstractNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String interpret() {
        return left.interpret() + "再" + right.interpret();
    }
}

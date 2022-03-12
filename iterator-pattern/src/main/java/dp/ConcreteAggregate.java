package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class ConcreteAggregate implements Aggregate {
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}

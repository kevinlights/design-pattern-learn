package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class ConcreteIterator implements Iterator {
    private ConcreteAggregate object;
    private int cursor;

    public ConcreteIterator(ConcreteAggregate object) {
        this.object = object;
    }

    @Override
    public void first() {

    }

    @Override
    public void next() {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object currentItem() {
        return null;
    }
}

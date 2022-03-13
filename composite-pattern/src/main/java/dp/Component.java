package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public abstract class Component {
    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract Component getChild(int i);
    public abstract void operation();
}

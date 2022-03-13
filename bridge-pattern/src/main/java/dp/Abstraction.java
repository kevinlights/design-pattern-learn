package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public abstract class Abstraction {
    protected Implementor impl;

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    public abstract void operation();
}

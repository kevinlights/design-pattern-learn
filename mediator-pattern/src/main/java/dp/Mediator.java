package dp;

import java.util.List;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public abstract class Mediator {
    protected List<Colleague> colleagues;

    public void register(Colleague colleague) {
        colleagues.add(colleague);
    }

    public abstract void operation();
}

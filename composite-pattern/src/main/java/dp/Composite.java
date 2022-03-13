package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class Composite extends Component {
    private List<Component> list = new ArrayList<>();

    @Override
    public void add(Component c) {
        list.add(c);
    }

    @Override
    public void remove(Component c) {
        list.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return list.get(i);
    }

    @Override
    public void operation() {
        for (Component c : list) {
            c.operation();
        }
    }
}

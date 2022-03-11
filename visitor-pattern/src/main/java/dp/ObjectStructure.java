package dp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class ObjectStructure {
    private ArrayList<Element> list = new ArrayList<>();

    public void accept(Visitor visitor) {
        Iterator<Element> i = list.iterator();
        while (i.hasNext()) {
            ((Element) i.next()).accept(visitor);
        }
    }

    public void addElement(Element element) {
        list.add(element);;
    }

    public void removeElement(Element element) {
        list.remove(element);
    }
}

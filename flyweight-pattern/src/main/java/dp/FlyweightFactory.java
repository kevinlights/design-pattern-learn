package dp;

import java.util.HashMap;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class FlyweightFactory {
    // 存储享元对象，实现享元池
    private HashMap<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (flyweights.containsKey(key)) {
            return flyweights.get(key);
        } else {
            Flyweight fw = new ConcreteFlyweight("");
            flyweights.put(key, fw);
            return fw;
        }
    }
}

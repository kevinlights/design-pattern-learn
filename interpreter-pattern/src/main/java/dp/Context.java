package dp;

import java.util.HashMap;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class Context {
    private final HashMap<String, String> map = new HashMap<>();

    public void assign(String key, String value) {
        // 往环境中设置值
        map.put(key, value);
    }

    public String lookup(String key) {
        // 获取存储在环境中的值
        return map.get(key);
    }
}

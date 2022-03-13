package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class Proxy extends Subject {
    // 引用真实主题对象
    private RealSubject realSubject = new RealSubject();

    @Override
    public void request() {
        // 调用真实主题业务方法
        realSubject.request();
    }
}

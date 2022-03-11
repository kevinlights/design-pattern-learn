package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new ConcreteStrategy();
        context.setStrategy(strategy);
        context.algorithm();
    }
}

package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
    }
}

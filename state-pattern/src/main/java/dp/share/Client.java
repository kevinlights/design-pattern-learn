package dp.share;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class Client {
    public static void main(String[] args) {
        Switch s1, s2;
        s1 = new Switch("Switch 1");
        s2 = new Switch("Switch 2");

        s1.on();
        s2.on();
        s1.off();
        s2.off();
        s2.on();
        s1.on();
    }
}

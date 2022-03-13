package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class Facade {
    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();

    public void method() {
        subSystemA.methodA();
        subSystemB.methodB();
    }
}

package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public abstract class AbstractClass {
    public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        primitiveOperation3();
    }

    public void primitiveOperation1() {}
    public abstract void primitiveOperation2();
    public void primitiveOperation3() {}
}

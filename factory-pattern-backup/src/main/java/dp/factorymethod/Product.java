package dp.factorymethod;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public abstract class Product {
    public void commonMethod() {
        System.out.println("Product commonMethod");
    }

    abstract void subMethod();
}

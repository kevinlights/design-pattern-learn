package dp.simplefactory;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class Factory {

    public static Product createProduct(String type) throws Exception {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        } else if("B".equals(type)) {
            return new ConcreteProductB();
        }
        throw new Exception("No this product.");
    }
}

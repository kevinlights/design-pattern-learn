package com.gjh.learn.dp.simplefactory;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public abstract class Product {

    public void commonMethod() {
        System.out.println("common Method");
    }

    abstract void subMethod();

    public static Product build(String type) throws Exception {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        } else if("B".equals(type)) {
            return new ConcreteProductB();
        }
        throw new Exception("No this product.");
    }
}

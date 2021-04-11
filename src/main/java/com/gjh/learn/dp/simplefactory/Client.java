package com.gjh.learn.dp.simplefactory;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Product productA = Factory.createProduct("A");
        productA.commonMethod();
        productA.subMethod();

        Product productB = Factory.createProduct("B");
        productB.commonMethod();
        productB.subMethod();
    }
}

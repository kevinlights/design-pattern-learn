package com.gjh.learn.dp.factorymethod;

import java.security.ProtectionDomain;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryB();
        Product product = factory.build();
        product.commonMethod();
        product.subMethod();
    }
}

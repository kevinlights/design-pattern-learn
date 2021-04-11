package com.gjh.learn.dp.factorymethod;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class ConcreteProductB extends Product {
    @Override
    void subMethod() {
        System.out.println("ConcreteProductB -> subMethod");
    }
}

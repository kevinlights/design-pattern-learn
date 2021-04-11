package com.gjh.learn.dp.factorymethod;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class ConcreteProductA extends Product{
    @Override
    void subMethod() {
        System.out.println("ConcreteProductA -> subMethod");
    }
}

package com.gjh.learn.dp.factorymethod;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class ConcreteFactoryB extends Factory{
    @Override
    Product build() {
        return new ConcreteProductB();
    }
}

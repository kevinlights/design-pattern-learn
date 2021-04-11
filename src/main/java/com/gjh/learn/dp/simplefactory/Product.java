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
}

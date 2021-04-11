package com.gjh.learn.dp.factorymethod;

import com.gjh.learn.dp.utils.XmlUtil;

import java.security.ProtectionDomain;

/**
 * created on 2021/4/11
 *
 * @author kevinlights
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String factoryClass = XmlUtil.getValue("factory-method", "factory-class");

        Factory factory = (Factory) Class.forName(factoryClass).newInstance();
        Product product = factory.build();
        product.commonMethod();
        product.subMethod();
    }
}

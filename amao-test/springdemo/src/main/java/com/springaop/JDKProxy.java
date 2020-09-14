package com.springaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理
 * 只能代理实现了接口的类，动态代理类的字节码在程序运行时由Java反射机制动态生成。
 */
public class JDKProxy implements InvocationHandler {
    private Object ImpClass;
    //private Object IObject;

    public JDKProxy(Object realObject) {
        this.ImpClass = realObject;
    }

    public Object bind(Object impclass) {
        //this.ImpClass = impclass;
        return Proxy.newProxyInstance(impclass.getClass().getClassLoader(), impclass.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("事务开始.....");
        String name = null;
        if (args != null) {
            name = (String) args[0];
            switch (name) {
                case "武庚纪":
                    name = "镇魂街";
                    break;
                case "六学":
                    name = "两开花";
                    break;
                default:
                    name = "";
                    break;
            }

        }
        method.invoke(ImpClass, name);
        System.out.println("事务结束.....");
        return null;
    }
}

class Client {
    public static void main(String[] args) {
        AddBookImpl addBook = new AddBookImpl();
        JDKProxy jdkProxy = new JDKProxy(addBook);

        AddBook bind = (AddBook) jdkProxy.bind(addBook);
        //System.out.println(bind.getClass().getName());

        bind.addBook("阿修罗");
    }
}

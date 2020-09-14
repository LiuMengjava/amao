package com.springaop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *  cglib 代理
 *  Cglib是可以代理没有实现接口的类，cglib是针对类来实现代理的，
 *  他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，
 *  所以不能对final修饰的类进行代理。底层采用ASM实现。
 */
public class Cglibproxy implements MethodInterceptor {
    private Object object;

    public Object getInstance(Object target){
        this.object=target;
        Enhancer enhancer = new Enhancer();
        // 设置自己的父类
        enhancer.setSuperclass(target.getClass());
        // 关联的要使用哪个对象的回调函数 这里指向自己这个对象的回调 那么就是下面这个方面了
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始......");
        objects[0] = "小六";
        methodProxy.invokeSuper(o,objects);
        System.out.println("事务结束......");
        return null;
    }

    public static void main(String[] args) {
        Cglibproxy cglibproxy = new Cglibproxy();
        AddBookImpl addBook = (AddBookImpl) cglibproxy.getInstance(new AddBookImpl());
        addBook.addBook("六学");
    }
}

package com.zhouyer.spbdemo.study.designpatterns.singleton.type8;

/**
 * @ClassName Singleton
 * @Description 单例模式-枚举方式实现
 * @Author zhouyer
 * @Date 2020/10/7 21:08
 * @Version 1.0
 **/
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton1 == singleton2);
        Singleton.INSTANCE.method();
    }
}

enum Singleton {
    INSTANCE;
    public void method() {
        System.out.println("hello world");
    }
}

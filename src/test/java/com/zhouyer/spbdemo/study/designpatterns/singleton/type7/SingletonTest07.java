package com.zhouyer.spbdemo.study.designpatterns.singleton.type7;

/**
 * @ClassName SingletonTest07
 * @Description 单例模式-静态内部类实现
 * @Author zhouyer
 * @Date 2020/10/7 20:47
 * @Version 1.0
 **/
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton == singleton1);
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
    }
}

class Singleton {
    private Singleton() {
    }

    // 静态内部类
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

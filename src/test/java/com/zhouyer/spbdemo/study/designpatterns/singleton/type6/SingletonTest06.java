package com.zhouyer.spbdemo.study.designpatterns.singleton.type6;

/**
 * @ClassName SingletonTest06
 * @Description 双重校验
 * @Author zhouyer
 * @Date 2020/10/6 21:25
 * @Version 1.0
 **/
public class SingletonTest06 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(singleton == singleton1);
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
    }
}

class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

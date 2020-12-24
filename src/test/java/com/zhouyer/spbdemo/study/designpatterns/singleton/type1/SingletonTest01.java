package com.zhouyer.spbdemo.study.designpatterns.singleton.type1;

/**
 * @ClassName SingletonTest01
 * @Description 单例模式测试-饿汉式（静态常量）
 * @Author zhouyer
 * @Date 2020/10/6 20:23
 * @Version 1.0
 **/
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}

class Singleton {
    //1、私有化构造函数，防止new
    private Singleton() {
    }

    //该类内部创建对象实例
    private static final Singleton instance = new Singleton();

    //提供访问该类对象实例的唯一公共方法
    public static Singleton getInstance() {
        return instance;
    }
}

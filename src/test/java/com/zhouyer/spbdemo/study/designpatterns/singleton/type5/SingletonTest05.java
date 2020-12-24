package com.zhouyer.spbdemo.study.designpatterns.singleton.type5;

/**
 * @ClassName SingletonTest01
 * @Description 单例模式测试-懒汉式（线程安全，同步代码块）
 * @Author zhouyer
 * @Date 2020/10/6 20:23
 * @Version 1.0
 **/
public class SingletonTest05 {
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
    private static Singleton instance;

    //提供访问该类对象实例的唯一公共方法
    public static Singleton getInstance() {
        if (null == instance) {
            //解决不了线程安全问题，也会产生多个实例
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}

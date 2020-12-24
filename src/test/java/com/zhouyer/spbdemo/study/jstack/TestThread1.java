package com.zhouyer.spbdemo.study.jstack;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName TestThread1
 * @Description 死锁测试线程，线程信息分析
 * @Author zhouyer
 * @Date 2020/8/12 0:39
 * @Version 1.0
 **/
public class TestThread1 {
    private Object object1 = new Object();

    private Object object2 = new Object();


    public void fun1() {
        synchronized (object1) {
            fun2();
        }
    }

    public void fun2() {
        synchronized (object2) {
            while (true) {
                System.out.println("fun2");
            }
        }
    }

    public static void main(String[] args) {
        TestThread1 t = new TestThread1();
        t.fun1();
    }
}

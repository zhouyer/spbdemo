package com.zhouyer.spbdemo.study.thread;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName CreateThread
 * @Description 创建线程
 * @Author zhouyer
 * @Date 2020/4/23 23:36
 * @Version 1.0
 **/
@SpringBootTest
public class CreateThread {
    @Test
    @Ignore
    public void thread1() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Test
    @Ignore
    public void thread2() {
        Thread thread = new Thread(new MyRunnable(), "New Thread");
        thread.start();
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void thread3() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new Thread("Thread-" + i) {
                public void run() {
                    System.out.println("Thread:" + getName() + "Running");
                }
            }.start();
        }
        //结果：
//        main
//        Thread:Thread-0Running
//        Thread:Thread-2Running
//        Thread:Thread-6Running
//        Thread:Thread-3Running
//        Thread:Thread-5Running
//        Thread:Thread-4Running
//        Thread:Thread-8Running
//        Thread:Thread-7Running
//        Thread:Thread-9Running
//        Thread:Thread-1Running
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {

        System.out.println("Runnable Thread Body" + Thread.currentThread().getName());
    }
}

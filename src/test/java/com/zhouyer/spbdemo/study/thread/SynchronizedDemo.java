package com.zhouyer.spbdemo.study.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName SynchronizedDemo
 * @Description 同步 synchronized
 * @Author zhouyer
 * @Date 2020/4/25 20:29
 * @Version 1.0
 **/
@SpringBootTest
public class SynchronizedDemo {
    @Test
    public void test1() {
        Calculate calculate = new Calculate();
        for (int i = 0; i < 10; i++) {
            new Thread(calculate).start();
        }
    }

    @Test
    public void test2() throws InterruptedException {
        MySynchronized mySynchronized = new MySynchronized();

        Thread thread1 = new Thread(() ->
                mySynchronized.print1()
        );

        MySynchronized mySynchronized1 = new MySynchronized();
        Thread thread2 = new Thread(() ->
                mySynchronized1.print2()
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main over");

    }
}

class Calculate implements Runnable {
    private int val = 0;

    public synchronized void add() {
        this.val++;
        System.out.println(Thread.currentThread().getName() + ":" + this.val);
    }

    @Override
    public void run() {
        //add();
    }
}

class MySynchronized {
    public synchronized void print1() {
        synchronized (MySynchronized.class){
            System.out.println("----开始执行prit1----");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----完成执行prit1----");
        }
    }

    public static synchronized void print2() {
        System.out.println("----开始执行prit2----");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----完成执行prit2----");
    }
}

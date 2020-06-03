package com.zhouyer.spbdemo.study.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName waitNotifyDemo
 * @Description 线程通信
 * @Author zhouyer
 * @Date 2020/4/26 23:20
 * @Version 1.0
 **/

public class waitNotifyDemo {
    public static void main(String[] args){
        String lock = new String("aba");
        for (int i = 1; i <= 4; i++) {
            new MyProducer(lock).start();
        }
        for (int i = 1; i <= 3; i++) {
            new MyConsumer(lock).start();
        }
    }
}

class Constans {
    public static int COUNT = 0;
    public static int SIZE = 10;
}

/**
 * 生产者线程
 */
class MyProducer extends Thread {
    private String lock;

    public MyProducer(String lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                while (Constans.COUNT == Constans.SIZE) {
                    try {
                        System.out.println(Thread.currentThread().getName()+"生产者等待消费者");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Constans.COUNT++;
                System.out.println("线程：" + Thread.currentThread().getName() + "生产了，仓库总共" + Constans.COUNT);
                if (Constans.COUNT >= 4) {
                    System.out.println(Thread.currentThread().getName()+"生产者通知消费者");
                    lock.notifyAll();
                }
            }
        }
    }
}

/**
 * 消费者线程
 */
class MyConsumer extends Thread {
    private String lock;

    public MyConsumer(String lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                while (Constans.COUNT == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName()+"消费者等待生产者");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Constans.COUNT--;
                System.out.println("线程：" + Thread.currentThread().getName() + "消费了，仓库剩余" + Constans.COUNT);
                if (Constans.COUNT <= 2) {
                    System.out.println(Thread.currentThread().getName()+"消费者唤醒生产者");
                    lock.notifyAll();
               }
            }
        }
    }
}

package com.zhouyer.spbdemo.study.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

/**
 * @ClassName ThreadCommunication
 * @Description 线程通信
 * @Author zhouyer
 * @Date 2020/4/26 0:09
 * @Version 1.0
 **/
@SpringBootTest
public class ThreadCommunication {
    @Test
    public void test1() {
        String lock = new String("123");
        Producer producer = new Producer(lock);
        Producer producer1 = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        producer.start();
        producer1.start();
        consumer.start();
    }

    @Test
    public void Test2(){
        String str1 = new String("aba");
        String str2 = "aba";
        String str3 = "aba";
        String str4 = new String("aba");
        System.out.println(str1 == str2);//false
        System.out.println(str2 == str3);//true
        System.out.println(str1 == str4);//false
        Integer var = -129;
        Integer var2 = -129;
        System.out.println(var == var2);
    }
}

class ObjectValue {
    public static String value = "";
}

/**
 * 生产者线程
 */
class Producer extends Thread {
    private String lock = null;

    public Producer(String lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    //如果value不为空，那么就还没有消费，等待消费者消费后才能生产
                    if (!Objects.equals("", ObjectValue.value)) {
                        lock.wait();
                    }
                    //生产者生产
                    String value = System.currentTimeMillis() + "_" + System.nanoTime();
                    System.out.println("Producer 生产" + value);
                    ObjectValue.value = value;
                    //生产完后，唤醒（通知）等待该对象锁的线程
                    lock.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

/**
 * 消费者线程
 */
class Consumer extends Thread {
    private String lock;

    public Consumer(String lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (lock) {
                    //如果value为空，说明消费完了，等待生产者生产
                    if (Objects.equals("", ObjectValue.value)) {
                        lock.wait();
                    }
                    //消费者消费
                    System.out.println("Consumer 消费" + ObjectValue.value);
                    ObjectValue.value = "";
                    //消费完了，通知（唤醒）生产者线程继续生产
                    lock.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

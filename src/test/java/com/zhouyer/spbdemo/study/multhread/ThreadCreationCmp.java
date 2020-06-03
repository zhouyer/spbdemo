package com.zhouyer.spbdemo.study.multhread;

import java.util.Random;

/**
 * @ClassName ThreadCreationCmp
 * @Description 继承Thread与实现Runnable接口创建线程的区别
 * @Author zhouyer
 * @Date 2020/3/28 23:24
 * @Version 1.0
 **/
public class ThreadCreationCmp {
    public static void main(String[] args) {
        final int numberOfProceesors = Runtime.getRuntime().availableProcessors();
        Thread t;
        CountingTask countingTask = new CountingTask();
        for(int i=1;i<=2*numberOfProceesors;i++){
            t = new Thread(countingTask);
            t.start();
        }

        for(int i=1;i<=2*numberOfProceesors;i++){
            t = new CountingThread();
            t.start();
        }
    }

    /**
     * 计算类
     */
    static class Counter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    /**
     * 实现Runnable接口创建线程
     */
    static class CountingTask implements Runnable {
        private Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomeThing();
                counter.increment();
            }

            System.out.println("CountingTask result：" + counter.getCount());
        }

        private void doSomeThing() {
            Random random = new Random();
            int randomNum = random.nextInt(80) + 1;
            try {
                Thread.sleep(randomNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CountingThread extends Thread {
        Counter counter = new Counter();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                doSomeThing();
                counter.increment();
            }
            System.out.println("CountingThread result：" + counter.getCount());
        }

        private void doSomeThing() {
            Random random = new Random();
            int randomNum = random.nextInt(80) + 1;
            try {
                Thread.sleep(randomNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

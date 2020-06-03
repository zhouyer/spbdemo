package com.zhouyer.spbdemo.study.multhread;

/**
 * @ClassName SimpleThread
 * @Description 简单的倒计时
 * @Author zhouyer
 * @Date 2020/3/29 12:43
 * @Version 1.0
 **/
public class SimpleThread {
    private static int count = 60;

    public static void main(String[] args) {
        while (true) {
            System.out.println("倒计时：" + count);
            countDown();
            if (0 == count) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void countDown() {
        count--;
    }
}

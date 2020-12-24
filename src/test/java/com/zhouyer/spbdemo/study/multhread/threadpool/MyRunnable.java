package com.zhouyer.spbdemo.study.multhread.threadpool;

import java.util.Date;

/**
 * @ClassName MyRunnable
 * @Description 实现Runnable接口的任务
 * @Author zhouyer
 * @Date 2020/8/23 18:09
 * @Version 1.0
 **/
public class MyRunnable implements Runnable {


    private String msg;

    public MyRunnable(String msg) {
        this.msg = msg;
    }

    /**
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time =" + new Date());
        processTask();
        System.out.println(Thread.currentThread().getName() + " End. Time =" + new Date());
    }

    private void processTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

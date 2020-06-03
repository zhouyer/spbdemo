package com.zhouyer.spbdemo.study.jstack;


/**
 * @ClassName JstackDemo1
 * @Description jstack实例
 * @Author zhouyer
 * @Date 2020/4/27 21:43
 * @Version 1.0
 **/
public class JstackDemo1 {
    public static void main(String[] args){
        Object lock = new Object();
        CalculateTask task1 = new CalculateTask(lock);
        CalculateTask task2 = new CalculateTask(lock);
        new Thread(task1).start();
        new Thread(task2).start();
    }

}

class CalculateTask implements Runnable {
    private Object lock;

    public CalculateTask(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            calculate();
        }
    }

    public void calculate() {
        int i = 0;
        while (true) {
            i++;
        }
    }
}

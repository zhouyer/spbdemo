package com.zhouyer.spbdemo.lock.distributedlock;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName TicketTaskDemo
 * @Description TODO
 * @Author zhouyer
 * @Date 2020/6/3 20:56
 * @Version 1.0
 **/
@Component
public class TicketTaskDemo {
    /**
     * 100张票
     */
    private int ticketsNum = 100;

    //Lock lock = new ReentrantLock();
    @Autowired
    @Qualifier("myDbLock")
    private Lock myDbLock;

    public void dbLockTest() throws InterruptedException {
        TicketTask task = new TicketTask();
        Thread thread1 = new Thread(task, "窗口A");
        Thread thread2 = new Thread(task, "窗口B");
        Thread thread3 = new Thread(task, "窗口C");
        Thread thread4 = new Thread(task, "窗口D");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.currentThread().join();

    }

    public class TicketTask implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            while (ticketsNum > 0) {
                myDbLock.lock();
                try {
                    if (ticketsNum > 0) {
                        System.out.println(Thread.currentThread().getName() + "卖出第" + ticketsNum-- + "张票");
                    }
                } catch (Exception e) {

                } finally {
                    myDbLock.unlock();
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

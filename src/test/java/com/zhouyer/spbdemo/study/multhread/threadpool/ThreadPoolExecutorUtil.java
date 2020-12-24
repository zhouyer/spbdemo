package com.zhouyer.spbdemo.study.multhread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolExecutorUtil
 * @Description 使用ThreadPoolExecutor创建的线程池，并自定义线程工厂
 * @Author zhouyer
 * @Date 2020/8/23 18:14
 * @Version 1.0
 **/
public class ThreadPoolExecutorUtil {
    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 5;
    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 10;

    /**
     * 等待时间 1L
     */
    private static final long KEEP_ALIVE_TIME = 1L;
    /**
     * 任务队列大小
     */
    private static final int QUEUE_CAPACITY = 100;

    static class MyThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        MyThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = name + "pool-" +
                    poolNumber.getAndIncrement() +
                    "-测试线程-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            return t;
        }
    }

    /**
     * 获取线程池
     *
     * @return
     */
    public static ThreadPoolExecutor getThreadPool(String name) {
        return new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new MyThreadFactory(name),
                new ThreadPoolExecutor.AbortPolicy()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                super.beforeExecute(t, r);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
            }

            @Override
            protected void terminated() {
                super.terminated();
            }
        };
    }
}

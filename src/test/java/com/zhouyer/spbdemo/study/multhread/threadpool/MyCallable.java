package com.zhouyer.spbdemo.study.multhread.threadpool;

import java.util.concurrent.Callable;

/**
 * @ClassName MyCallable
 * @Description 实现Callable<T>接口的实例
 * @Author zhouyer
 * @Date 2020/8/24 23:44
 * @Version 1.0
 **/
public class MyCallable implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        // 返回当前执行的线程名字
        return Thread.currentThread().getName();
    }
}

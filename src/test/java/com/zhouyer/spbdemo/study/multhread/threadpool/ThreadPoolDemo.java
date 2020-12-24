package com.zhouyer.spbdemo.study.multhread.threadpool;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @ClassName ThreadPoolDemo
 * @Description 线程池测试
 * @Author zhouyer
 * @Date 2020/8/23 21:36
 * @Version 1.0
 **/
@SpringBootTest
public class ThreadPoolDemo {

    @Test
    @Ignore
    public void testRunnable() {
        ExecutorService executorService = ThreadPoolExecutorUtil.getThreadPool("测试Runnable任务");
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable("" + i));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        System.out.println("Finished all threads");
    }

    @Test
    public void testCallable() {
        ExecutorService executorService = ThreadPoolExecutorUtil.getThreadPool("测试Callable任务");
        List<Future<String>> futures = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            // 提交任务到线程池
            Future<String> future = executorService.submit(new MyCallable());
            // 将返回的Future添加到list
            futures.add(future);
        }
        //关闭线程池
        executorService.shutdown();
        // 遍历futures
        for (Future<String> futureTask : futures) {
            try {
                System.out.println(new Date() + ":" + futureTask.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

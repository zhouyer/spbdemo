package com.zhouyer.spbdemo.study.thread;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName ThreadSafe
 * @Description TODO
 * @Author zhouyer
 * @Date 2020/4/25 10:42
 * @Version 1.0
 **/
@SpringBootTest
public class ThreadSafe {
    @Test
    @Ignore
    public void test1() {
        Counter counter = new Counter();
        for (int i = 1; i <= 10; i++) {
            counter.add(1);
        }
        System.out.println(counter.getCount()); // 55
    }

    @Test
    @Ignore
    public void test1_1() {
        Counter counter = new Counter();
        for (int i = 1; i <= 10; i++) {
            new Thread("thread-" + i) {
                public void run() {
                    counter.add(1);
                }
            }.start();
        }
        System.out.println(counter.getCount()); // 3 执行多次结果不定
    }

    @Test
    @Ignore
    public void test2() {
        Counter counter = new Counter();
        for (int i = 1; i <= 10; i++) {
            new Thread("thread-" + i) {
                public void run() {
                    counter.someMethod();
                }
            }.start();
        }
        // 结果 打印 10个1，因为局部变量存放在栈上，这个是线程私有的
    }

    @Test
    public void test3() {
        //共享同一个NotThreadSafe对象
//        NotThreadSafe shareInstance = new NotThreadSafe();
//        for (int i = 1; i <= 10; i++) {
//            new Thread(new MyTask(shareInstance)).start();
//        }
        //    some Text,
        //    some Text,some Text,
        //    some Text,some Text,some Text,some Text,some Text,
        //    some Text,some Text,some Text,some Text,
        //    some Text,some Text,some Text,
        //    some Text,some Text,some Text,some Text,some Text,some Text,
        //    some Text,some Text,some Text,some Text,some Text,some Text,some Text,
        //    some Text,some Text,some Text,some Text,some Text,some Text,some Text,some Text,
        //    some Text,some Text,some Text,some Text,some Text,some Text,some Text,some Text,some Text,
        //    some Text,some Text,some Text,some Text,some Text,some Text,some Text,some Text,some Text,

        // 不共享，每个线程使用独立的NotThreadSafe
        for (int i = 1; i <= 5; i++) {
            new Thread(new MyTask(new NotThreadSafe())).start();
        }
    }

}

class Counter {
    protected long count = 0L;

    public void add(long val) {
        this.count = this.count + val;
    }

    public long getCount() {
        return this.count;
    }

    public void someMethod() {
        // 局部变量-线程安全的
        long threadSafeInt = 0;
        threadSafeInt++;
        System.out.println(threadSafeInt);
    }
}

class NotThreadSafe {
    StringBuilder builder = new StringBuilder();

    public void add(String val) {
        this.builder.append(val);
        System.out.println("thread:"+Thread.currentThread().getName()+"-"+this.builder);
    }
}

class MyTask implements Runnable {
    NotThreadSafe instance = null;

    public MyTask(NotThreadSafe notThreadSafe) {
        this.instance = notThreadSafe;
    }

    @Override
    public void run() {
        if (null != this.instance) {
            this.instance.add("some Text,");
        }
    }
}



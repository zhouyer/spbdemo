package com.zhouyer.spbdemo.study.lock;

import com.zhouyer.spbdemo.lock.distributedlock.TicketTaskDemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName LockTest
 * @Description 各种锁测试类
 * @Author zhouyer
 * @Date 2020/5/9 23:07
 * @Version 1.0
 **/
@SpringBootTest
public class LockTest {
    @Autowired
    private TicketTaskDemo ticketTaskDemo;

    @Test
    public void distributedLockTest() {
        try {
            ticketTaskDemo.dbLockTest();
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
    }
}

package com.zhouyer.spbdemo.controller;

import com.zhouyer.spbdemo.lock.optimistic.AutoIncrementService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LockController
 * @Description TODO
 * @Author zhouyer
 * @Date 2020/5/10 15:26
 * @Version 1.0
 **/
@RestController
@RequestMapping("api")
public class LockController {
    @Autowired
    private AutoIncrementService autoIncrementService;

    @GetMapping("/lock")
    public String lockTest() {
        new Thread(autoIncrementService).start();
        return "ok";
    }

    @GetMapping("/lock/thread")
    public String lockThreadTest() {
        for (int i = 1; i <= 10; i++) {
            new Thread(autoIncrementService).start();
        }
        return "ok";
    }
}

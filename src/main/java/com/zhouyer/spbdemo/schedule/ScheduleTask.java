package com.zhouyer.spbdemo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScheduleTask
 * @Description 定时调度任务
 * @Author zhouyer
 * @Date 2019/12/1 22:38
 * @Version 1.0
 **/
@Component
public class ScheduleTask {

    @Scheduled(cron = "0/5 * * * * ?")
    private void execute() {
        System.out.println("执行定时任务...");
    }
}

package com.zhouyer.spbdemo.study.designpatterns.chainofcommand;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName Client
 * @Description 责任链测试类
 * @Author zhouyer
 * @Date 2020/9/6 23:03
 * @Version 1.0
 **/
@SpringBootTest
public class Client {

    @Test
    public void ChainOfCommandTest() {
        LeaveApprovalHandler director = new DirectorApproval("张三");
        LeaveApprovalHandler manager = new ManagerApproval("李四");
        LeaveApprovalHandler topManager = new TopManagerApproval("王五");

        //创建责任链
        director.setNextApprovalHandler(manager);
        manager.setNextApprovalHandler(topManager);

        //请假申请
        // 发起请假申请
        boolean result1 = director.handlerApproval(LeaveInfo.builder().leavePersonName("yuyu").leaveNumber(3).leaveReason("肚子痛").build());
        System.out.println("最终结果：" + result1 + "\n");

        boolean result2 = director.handlerApproval(LeaveInfo.builder().leavePersonName("yuyu").leaveNumber(5).leaveReason("肚子痛").build());
        System.out.println("最终结果：" + result2 + "\n");

        boolean result3 = director.handlerApproval(LeaveInfo.builder().leavePersonName("yuyu").leaveNumber(8).leaveReason("肚子痛").build());
        System.out.println("最终结果：" + result3 + "\n");
    }
}

package com.zhouyer.spbdemo.study.designpatterns.chainofcommand;

import java.util.Random;

/**
 * @ClassName TopManagerApproval
 * @Description 总经理审批相关操作
 * @Author zhouyer
 * @Date 2020/9/6 22:52
 * @Version 1.0
 **/
public class TopManagerApproval extends LeaveApprovalHandler {
    public TopManagerApproval(String name) {
        super(name, 7);
    }

    /**
     * 处理请假
     *
     * @param leaveInfo 请假相关信息
     * @return boolean
     */
    @Override
    protected boolean approval(LeaveInfo leaveInfo) {
        boolean result = (new Random().nextInt(20)) > 1; // 随机数大于3则为批准，否则不批准
        String log = "总经理<%s> 审批 <%s> 的请假申请，请假天数： <%d> ，审批结果：<%s> ";
        Integer leaveNum = leaveInfo.getLeaveNumber();
        System.out.println(String.format(log, this.approver, leaveInfo.getLeavePersonName(), leaveNum, result == true ? "批准" : "不批准"));
        return result;
    }
}

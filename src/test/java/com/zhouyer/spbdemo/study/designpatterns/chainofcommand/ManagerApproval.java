package com.zhouyer.spbdemo.study.designpatterns.chainofcommand;

import java.util.Random;

/**
 * @ClassName ManagerApproval
 * @Description 经理审批相关操作
 * @Author zhouyer
 * @Date 2020/9/6 22:51
 * @Version 1.0
 **/
public class ManagerApproval extends LeaveApprovalHandler {
    public ManagerApproval(String name) {
        super(name, 5);
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
        String log = "经理<%s> 审批 <%s> 的请假申请，请假天数： <%d> ，审批结果：<%s> ";
        Integer leaveNum = leaveInfo.getLeaveNumber();
        System.out.println(String.format(log, this.approver, leaveInfo.getLeavePersonName(), leaveNum, result == true ? "批准" : "不批准"));
        return result;
    }
}

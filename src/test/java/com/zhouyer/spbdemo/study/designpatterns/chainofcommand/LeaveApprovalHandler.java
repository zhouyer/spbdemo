package com.zhouyer.spbdemo.study.designpatterns.chainofcommand;

import lombok.Data;

/**
 * @ClassName LeaveApprovalHandler
 * @Description 请假审批抽象类
 * @Author zhouyer
 * @Date 2020/9/6 22:43
 * @Version 1.0
 **/
@Data
public abstract class LeaveApprovalHandler {

    /**
     * 审批人
     */
    protected String approver;

    /**
     * 最小审批天数
     */
    private int minLeaveNumb = 0;

    /**
     * 下一个请假审批处理者
     */
    protected LeaveApprovalHandler nextApprovalHandler;

    public LeaveApprovalHandler(String name, int minLeaveNumb) {
        this.approver = name;
        this.minLeaveNumb = minLeaveNumb;
    }

    /**
     * 处理审批
     *
     * @param leaveInfo
     * @return
     */
    public final boolean handlerApproval(LeaveInfo leaveInfo) {
        if (leaveInfo.getLeaveNumber() <= this.minLeaveNumb) {
            return this.approval(leaveInfo);
        }else{
            boolean flag = this.approval(leaveInfo);
            if(flag==false){
                return false;
            }
        }
        if (null != this.nextApprovalHandler) {
            return this.nextApprovalHandler.handlerApproval(leaveInfo);
        }
        return false;
    }

    /**
     * 请假审批，具体审批情况交由子类来实现
     *
     * @param leaveInfo 请假相关信息
     * @return boolean
     */
    protected abstract boolean approval(LeaveInfo leaveInfo);
}

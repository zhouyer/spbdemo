package com.zhouyer.spbdemo.study.designpatterns.chainofcommand;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LeaveInfo
 * @Description 请假信息
 * @Author zhouyer
 * @Date 2020/9/6 22:38
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveInfo {
    /**
     * 请假人姓名
     */
    private String leavePersonName;

    /**
     * 请假天数
     */
    private Integer leaveNumber;

    /**
     * 请假原因
     */
    private String leaveReason;
}

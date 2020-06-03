package com.zhouyer.spbdemo.lock.optimistic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName GenKey
 * @Description 生成id的bean
 * @Author zhouyer
 * @Date 2020/5/10 0:11
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenKey {
    /**
     * id
     */
    private Integer id;
    /**
     * 值
     */
    private Integer value;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 使用状态（0：未使用，1：已使用）
     */
    private Integer status;
}

package com.zhouyer.spbdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserVO
 * @Description 用户信息
 * @Author zhouyer
 * @Date 2019/12/2 23:31
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
    private String username;

    private String password;
}

package com.zhouyer.spbdemo.service;

import com.zhouyer.spbdemo.vo.UserVO;

public interface ILoginService {
    /**
     * 用户登录
     * @param userVO 用户对象
     * @return
     */
    UserVO login(UserVO userVO);

    /**
     * 用户注销
     * @param userVO 用户对象
     * @return
     */
    boolean logout(UserVO userVO);
}

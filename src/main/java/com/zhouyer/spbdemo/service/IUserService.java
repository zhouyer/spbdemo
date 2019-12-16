package com.zhouyer.spbdemo.service;

import com.zhouyer.spbdemo.entity.User;
import sun.nio.cs.US_ASCII;

import java.util.List;

/**
 * @ClassName IUserService
 * @Description 用户服务接口
 * @Author zhouyer
 * @Date 2019/12/15 17:51
 * @Version 1.0
 **/
public interface IUserService {
    /**
     * 获取用户接口
     *
     * @return 用户信息
     */
    List<User> getUsers();

    /**
     * 根据用户名和密码获取用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    User getUser(String username, String password);
}

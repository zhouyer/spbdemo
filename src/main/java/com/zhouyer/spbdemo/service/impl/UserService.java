package com.zhouyer.spbdemo.service.impl;

import com.zhouyer.spbdemo.entity.User;
import com.zhouyer.spbdemo.repository.UserRepository;
import com.zhouyer.spbdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LoginService
 * @Description 用户登录服务
 * @Author zhouyer
 * @Date 2019/12/15 17:47
 * @Version 1.0
 **/
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户接口
     *
     * @return
     */
    @Override
    @Cacheable(value = "users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * 根据用户名和密码获取用户信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @Override
    public User getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}

package com.zhouyer.spbdemo.service.impl;

import com.zhouyer.spbdemo.entity.User;
import com.zhouyer.spbdemo.service.ILoginService;
import com.zhouyer.spbdemo.service.IUserService;
import com.zhouyer.spbdemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author zhouyer
 * @Date 2019/12/15 18:19
 * @Version 1.0
 **/
@Service
public class LoginService implements ILoginService {
    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     *
     * @param userVO 用户对象
     * @return
     */
    @Override
    public UserVO login(UserVO userVO) {
        User user = userService.getUser(userVO.getUsername(), userVO.getPassword());
        if (null == user) {
            return null;
        }
        return UserVO.builder().username(user.getUsername()).build();
    }

    /**
     * 用户注销
     *
     * @param userVO 用户对象
     * @return
     */
    @Override
    public boolean logout(UserVO userVO) {
        return false;
    }
}

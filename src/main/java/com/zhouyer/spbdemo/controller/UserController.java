package com.zhouyer.spbdemo.controller;

import com.zhouyer.spbdemo.constants.annotation.Timer;
import com.zhouyer.spbdemo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Description 用户控制类
 * @Author zhouyer
 * @Date 2019/12/3 0:38
 * @Version 1.0
 **/
@Controller
@RequestMapping("api/")
@Api("用户相关操作接口")
public class UserController {
    /**
     * 测试接口
     * @return
     */
    @ResponseBody
    @GetMapping("/index")
    @ApiOperation("测试接口")
    public String index(){
        return "spring boot";
    }

    @GetMapping("/test")
    @ResponseBody
    @Timer
    public String getName(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test";
    }
}

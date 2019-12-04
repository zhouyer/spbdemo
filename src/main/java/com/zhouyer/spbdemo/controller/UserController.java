package com.zhouyer.spbdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description 用户控制类
 * @Author zhouyer
 * @Date 2019/12/3 0:38
 * @Version 1.0
 **/
@Controller
@RequestMapping("api/")
public class UserController {


    @ResponseBody
    @GetMapping("/index")
    public String index(){
        return "spring boot";
    }
}

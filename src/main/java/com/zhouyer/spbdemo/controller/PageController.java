package com.zhouyer.spbdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description 页面跳转Controller
 * @Author zhouyer
 * @Date 2019/12/3 23:38
 * @Version 1.0
 **/
@Controller
@RequestMapping("/page")
public class PageController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/index")
    public String adminPage() {
        return "admin/index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/userList")
    public String userList() {
        return "userList";
    }
}

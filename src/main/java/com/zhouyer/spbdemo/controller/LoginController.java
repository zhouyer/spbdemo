package com.zhouyer.spbdemo.controller;

import com.zhouyer.spbdemo.service.ILoginService;
import com.zhouyer.spbdemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description 登陆controller
 * @Author zhouyer
 * @Date 2019/12/15 17:18
 * @Version 1.0
 **/
@Controller
public class LoginController {
    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("pwd") String password) {
        UserVO userVO = loginService.login(UserVO.builder().username(username).password(password).build());
        if (null == userVO) {
            return "redirect:/page/login";
        }
        request.getSession().setAttribute("username", userVO.getUsername());
        return "redirect:/page/welcome";
    }

    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/page/login";
    }
}

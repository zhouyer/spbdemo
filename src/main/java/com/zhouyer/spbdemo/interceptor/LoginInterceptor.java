package com.zhouyer.spbdemo.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName LoginInterceptor
 * @Description 登录拦截器
 * @Author zhouyer
 * @Date 2019/12/15 18:27
 * @Version 1.0
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Value("#{'${login.page.url}'.split(',')}")
    private List<String> loginPageUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        String path = request.getRequestURI();
        if (null == username&&loginPageUrls.contains(path)) {
            response.sendRedirect("page/login");
            return false;
        }
        String loginName = (String) username;
        System.out.println("该用户已经登录，用户名为:" + loginName);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

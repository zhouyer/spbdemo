package com.zhouyer.spbdemo.config;

import com.zhouyer.spbdemo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @ClassName LoginConfig
 * @Description 登录配置
 * @Author zhouyer
 * @Date 2019/12/15 18:44
 * @Version 1.0
 **/
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations. Interceptors can be registered to apply
     * to all requests or be limited to a subset of URL patterns.
     * <p><strong>Note</strong> that interceptors registered here only apply to
     * controllers and not to resource handler requests. To intercept requests for
     * static resources either declare a
     * {@link MappedInterceptor MappedInterceptor}
     * bean or switch to advanced configuration mode by extending
     * {@link WebMvcConfigurationSupport
     * WebMvcConfigurationSupport} and then override {@code resourceHandlerMapping}.
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        // 注册登陆拦截器
        InterceptorRegistration loginInterceptorRegister = new InterceptorRegistration(loginInterceptor);
        loginInterceptorRegister.addPathPatterns("/**");
        //loginInterceptorRigister.excludePathPatterns();
        loginInterceptorRegister.excludePathPatterns("/page/login");
        loginInterceptorRegister.excludePathPatterns("/page/logout");
        loginInterceptorRegister.excludePathPatterns("/js/**/*.js");
    }

    /**
     * Configure simple automated controllers pre-configured with the response
     * status code and/or a view to render the response body. This is useful in
     * cases where there is no need for custom controller logic -- e.g. render a
     * home page, perform simple site URL redirects, return a 404 status with
     * HTML content, a 204 with no content, and more.
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/page/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }


}

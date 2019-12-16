package com.zhouyer.spbdemo.constants.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Timer
 * @Description 统计接口执行时间日志
 * @Author zhouyer
 * @Date 2019/12/15 22:50
 * @Version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Timer {
}

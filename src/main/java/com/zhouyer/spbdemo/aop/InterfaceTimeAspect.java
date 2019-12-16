package com.zhouyer.spbdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName InterfaceTimeAspect
 * @Description 接口执行时间AOP
 * @Author zhouyer
 * @Date 2019/12/15 22:34
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class InterfaceTimeAspect {
    /**
     * 切点
     */
    @Pointcut("@annotation(com.zhouyer.spbdemo.constants.annotation.Timer)")
    private void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 类名
        String className = joinPoint.getTarget().getClass().getName();
        // 方法名
        String methodName = joinPoint.getSignature().getName();

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long disTime = endTime - startTime;
        log.info("----------{}: {}:耗时: {} ms", className, methodName, disTime);
        return result;
    }

}

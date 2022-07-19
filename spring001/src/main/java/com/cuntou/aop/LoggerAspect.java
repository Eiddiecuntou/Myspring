package com.cuntou.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(public int com.cuntou.aop.CalImpl.add(..))")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(methodName + "方法的参数是" + Arrays.toString(args));
    }

    @AfterReturning(value = "execution(public int com.cuntou.aop.CalImpl.add(..))",returning = "result")
    public void after(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法的结果是" + result);
    }

}

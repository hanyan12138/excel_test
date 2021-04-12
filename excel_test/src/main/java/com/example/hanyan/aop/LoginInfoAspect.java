package com.example.hanyan.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 登录切面使用
 * @author vigo.xian
 */
@Aspect
@Component
@Slf4j
public class LoginInfoAspect {

    @Pointcut("execution(* com.example.hanyan.hanee.controller..*(..))")
    public void pointcut() { }



}

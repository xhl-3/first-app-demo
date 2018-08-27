package com.xhl.firstappdemo.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;


import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by xhl on 2018/8/27.
 */
@Aspect
@Configuration
public class MyIntercptor {

    @Pointcut("execution( * com.xhl.firstappdemo.controller.UserController.save(..))")
    public void myAspect(){
        System.out.println("切入点。。。。");
    }
    @Before("myAspect()")
    public void before(){
        System.out.println("切面before执行。。。。");
    }
}

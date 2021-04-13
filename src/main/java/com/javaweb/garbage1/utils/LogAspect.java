package com.javaweb.garbage1.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //定义切入点
    @Pointcut("@annotation(com.javaweb.garbage1.utils.SystemLog)")
    public void log(){
        System.out.println("切入点");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //接收请求，记录请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL:" + request.getRequestURI().toLowerCase(Locale.ROOT));
        logger.info("HTTP_METHOD:" + request.getMethod());
        logger.info("IP:" + request.getRemoteAddr());
    }

    @AfterReturning("log()")
    public void doAfterReturning(JoinPoint joinPoint){
        logger.info("==========================");
    }
}

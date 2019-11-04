package com.maple.controller;

import com.maple.mvc.controller.vo.AppRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;
import scala.App;

@Aspect
@Component
public class ControllerAspect {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.maple.controller.JsonController.*(..))")
    private void pointcut() {

    }

    @Around("pointcut()")
    public Object dealControllerArgs(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodInvocationProceedingJoinPoint methodJoinPoint = (MethodInvocationProceedingJoinPoint) joinPoint;

        Object[] args = methodJoinPoint.getArgs();

        AppRequest request = null;

        int requestIndex = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof AppRequest) {
                request = (AppRequest) args[i];
                requestIndex = i;
            }
        }

        if (request == null) {
            log.warn("ControllerAspect JoinPoint have no AppRequest");
            //不修改原有参数,直接执行
            return methodJoinPoint.proceed();
        }

        //存在 AppRequest
        String originSecret = request.getAppSecret();

        //处理你的逻辑
        request.setAppSecret(originSecret + "-已解密");


        //修改 args
        args[requestIndex] = request;

        return methodJoinPoint.proceed(args);

    }
}

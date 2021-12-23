package com.selevn.demo.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("@annotation(LogAnnotation)")
    public void allMethodsExec(){

    }

    @AfterReturning("allMethodsExec()")
    public void logSuccessMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        log.info(methodName + ": Done");
    }

    @AfterThrowing("allMethodsExec()")
    public void logFailMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        log.error(methodName + ": Failed");
    }
}
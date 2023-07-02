package com.hludov.spring.mvc_hibernate_aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {


    @Around("execution(* com.hludov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{


        MethodSignature methodSignature= (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();

        System.out.println("Start of "+methodName);

        Object proceed = proceedingJoinPoint.proceed();


        System.out.println("Method end "+proceed);


        return proceed;


    }




}

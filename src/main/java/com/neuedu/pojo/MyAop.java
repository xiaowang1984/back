package com.neuedu.pojo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class MyAop {

    @AfterReturning("execution(* com.neuedu.controller.*.*(..))")
    public void after(){
        System.out.println("方法调用后");
    }
    @Around("execution(* com.neuedu.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint ) throws Throwable {
        Object result=null;
        System.out.println("环绕前");
        result = joinPoint.proceed();
        System.out.println("环绕后");
        return result;
    }

}

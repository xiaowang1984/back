package com.neuedu.pojo;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法前");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("方法后");
        return result;
    }
}

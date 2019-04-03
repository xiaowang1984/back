package com.neuedu.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class ConnectionProxy implements InvocationHandler {
    private Object target;
    private List connections;

    public ConnectionProxy(Object target, List connections) {
        this.target = target;
        this.connections=connections;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if(method.getName().equals("close")){
            connections.add(this);
        }else{
            result = method.invoke(target,args);
        }
        return result;
    }
}

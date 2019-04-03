package com.neuedu;

import com.neuedu.pojo.CglibProxy;
import com.neuedu.pojo.Iphone;
import com.neuedu.pojo.MyProxy;
import com.neuedu.pojo.Phone;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class MyTest2 {
    public static void main(String[] args) {

        /*Iphone phone = new Phone();
        MyProxy myProxy = new MyProxy(phone);
        Iphone proxy = (Iphone) Proxy.newProxyInstance(Iphone.class.getClassLoader(),
                new Class[]{Iphone.class}, myProxy);
        proxy.product8();*/

       /* CglibProxy cglibProxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Phone.class);
        enhancer.setCallback(cglibProxy);
        Phone phone = (Phone) enhancer.create();
        phone.product9();*/
    }
}

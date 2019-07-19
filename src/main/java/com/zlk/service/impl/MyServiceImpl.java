package com.zlk.service.impl;

import org.springframework.stereotype.Service;

import com.zlk.service.MyService;

@Service("myService")  // µÈ¼ÛÓÚ==> <bean id="myService" class="com.zlk.service.impl.MyServiceImpl"></bean>
public class MyServiceImpl implements MyService {

    public void before() {
        System.out.println("before message");
    }

    public void after() {
//        int a = 10 / 0;
        System.out.println("after message");
    }

    public void around() {
        System.out.println("around message");
    }

    public void afterReturning() {
//        int a = 10 / 0;
        System.out.println("afterReturning message");
    }

    public void afterThrowing() {
        int a = 10 / 0;
        System.out.println("afterThrowing message");
    }
}

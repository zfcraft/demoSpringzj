package com.zlk.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zlk.service.MyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {

    @Resource(name = "myService")
    private MyService myService;

    @Test
    public void run1() {
        // 测试前置通知
//        myService.before();

        // 测试最终通知
        myService.after();

        // 测试后置通知
//        myService.afterReturning();

        // 测试环绕通知
//        myService.around();

        // 测试异常抛出通知
//        myService.afterThrowing();
    }
}
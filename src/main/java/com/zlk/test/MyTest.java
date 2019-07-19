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
        // ����ǰ��֪ͨ
//        myService.before();

        // ��������֪ͨ
        myService.after();

        // ���Ժ���֪ͨ
//        myService.afterReturning();

        // ���Ի���֪ͨ
//        myService.around();

        // �����쳣�׳�֪ͨ
//        myService.afterThrowing();
    }
}
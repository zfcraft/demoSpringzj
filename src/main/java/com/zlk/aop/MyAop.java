package com.zlk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect		// ʹ�� @Aspect �����������࣬ע�ⷽʽ����Ҫ��
@Component  // ���������ΪSpring�����Bean���ȼ��� ==>  <bean id="myAop" class="com.zlk.aop.MyAop"></bean>
public class MyAop {
    
    // �����
    @Pointcut("execution(* *..*.before(..))")
    public void anyMethod() { }

    // ���� @Pointcut
    // ǰ��֪ͨ
    // ��Ŀ����ķ���ִ��֮ǰִ��
    @Before("anyMethod()")
    public void beforeAdvice() {
        System.out.println("ǰ��֪ͨ��");
    }
    
    // ����֪ͨ
    // ��Ŀ����ķ���ִ��֮��ִ�У��������������쳣������֪ͨҲ��ִ��
    @After("execution(* *..*.after(..))")
    public void afterAdvice() {
        System.out.println("����֪ͨ��");
    }
    
    // ����֪ͨ
    // ��������ִ�к��֪ͨ, ��������쳣, �򲻻�ִ��
    @AfterReturning("execution(* *..*.afterReturning(..))")
    public void afterReturningAdvice() {
        System.out.println("����֪ͨ��");
    }
    
    // ����֪ͨ
    // ��Ŀ���෽����ִ��ǰ��ִ��
    @Around("execution(* *..*.around(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("����֪ͨ - ǰ");
        
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
        System.out.println("����֪ͨ - ��");
    }
    
    // �쳣�׳�֪ͨ
    // ��Ŀ���෽��ִ�г����쳣ʱ, �Ż���ø�֪ͨ
    @AfterThrowing("execution(* *..*.afterThrowing(..))")
    public void afterThrowingAdvice() {
        System.out.println("�쳣�׳�֪ͨ");
    }
}

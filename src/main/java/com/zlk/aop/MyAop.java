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

@Aspect		// 使用 @Aspect 来声明切面类，注解方式才需要加
@Component  // 让切面类成为Spring管理的Bean，等价于 ==>  <bean id="myAop" class="com.zlk.aop.MyAop"></bean>
public class MyAop {
    
    // 切入点
    @Pointcut("execution(* *..*.before(..))")
    public void anyMethod() { }

    // 测试 @Pointcut
    // 前置通知
    // 在目标类的方法执行之前执行
    @Before("anyMethod()")
    public void beforeAdvice() {
        System.out.println("前置通知！");
    }
    
    // 最终通知
    // 在目标类的方法执行之后执行，如果程序出现了异常，最终通知也会执行
    @After("execution(* *..*.after(..))")
    public void afterAdvice() {
        System.out.println("最终通知！");
    }
    
    // 后置通知
    // 方法正常执行后的通知, 程序出现异常, 则不会执行
    @AfterReturning("execution(* *..*.afterReturning(..))")
    public void afterReturningAdvice() {
        System.out.println("后置通知！");
    }
    
    // 环绕通知
    // 在目标类方法的执行前后执行
    @Around("execution(* *..*.around(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕通知 - 前");
        
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
        System.out.println("环绕通知 - 后");
    }
    
    // 异常抛出通知
    // 在目标类方法执行出现异常时, 才会调用该通知
    @AfterThrowing("execution(* *..*.afterThrowing(..))")
    public void afterThrowingAdvice() {
        System.out.println("异常抛出通知");
    }
}

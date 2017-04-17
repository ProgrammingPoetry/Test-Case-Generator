package com.jntu;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestAspect {
    private static boolean runAround = true;

    public static void main(String[] args) {
        new TestAspect().hello();
        runAround = false;
        new TestAspect().hello();
    }

    public void hello() {
        System.err.println("in hello");
    }

    @After("execution(void aspects.TestAspect.hello())")
    public void afterHello(JoinPoint joinPoint) {
        System.err.println("after " + joinPoint);
    }

    @Around("execution(void aspects.TestAspect.hello())")
    public void aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        System.err.println("in around before " + joinPoint);
        if (runAround) {
            joinPoint.proceed();
        }
        System.err.println("in around after " + joinPoint);
    }

    @Before("execution(void aspects.TestAspect.hello())")
    public void beforeHello(JoinPoint joinPoint) {
        System.err.println("before " + joinPoint);
    }
}
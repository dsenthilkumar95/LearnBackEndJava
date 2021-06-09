package com.improve.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SpringAOP {

    @Before("execution(* com.improve.javaBasics.Employee.get*())")
    public void beforeAdvice(){
        System.out.println("Before advice");
    }

    @After("execution(* com.improve.javaBasics.Employee.get*())")
    public void afterAdvice(){
        System.out.println("After advice");
    }
}

package com.yurchello.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.yurchello.aspectj.Customer.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* com.yurchello.aspectj.Customer.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {

		System.out.println("logAfter() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");

	}

    @AfterReturning(
            pointcut = "execution(* com.yurchello.aspectj.Customer.addCustomer(..))",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");
    }

    @Around("execution(* com.yurchello.aspectj.Customer.addCustomerAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");

    }

    @AfterThrowing(
            pointcut = "execution(* com.yurchello.aspectj.Customer.addCustomerThrowException(..))",
            throwing= "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {

        System.out.println("logAfterThrowing is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + e.getMessage());
        System.out.println("******");
    }

}
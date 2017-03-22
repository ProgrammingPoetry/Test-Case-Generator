package com.jntu.logging;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RandomInterfaceLogs {

	private static Logger log;

	@Pointcut("execution(* com.jntu.random.*.*.*(..))")
	private void randomInterfaceLogs() {

	}

	@Before("randomInterfaceLogs()")
	public void beforeAdvice(JoinPoint joinPoint) {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringTypeName());
		log.info(joinPoint.getSignature().getName() + "() method has been invoked");
		log.info("Arguments are :" + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(value = "randomInterfaceLogs()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringTypeName());
		log.info("Returning from the method "+joinPoint.getSignature().getName()+"()");
	}
	
	@AfterThrowing(pointcut = "randomInterfaceLogs()", throwing = "error")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringTypeName());
		log.severe(error.toString());
	}

}

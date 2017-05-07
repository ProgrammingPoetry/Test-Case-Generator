package com.jntu.logging;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLayerLogs {

	private static Log log;

	@Pointcut("execution(* com.jntu.service.*.*.*(..))")
	private void serviceLayerLogs() {

	}

	@Before("serviceLayerLogs()")
	public void beforeAdvice(JoinPoint joinPoint) {
		log = LogFactory.getLog(joinPoint.getSignature().getDeclaringTypeName());
		log.debug(joinPoint.getSignature().getName() + "() method has been invoked");
		log.trace("Arguments are :" + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(value = "serviceLayerLogs()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		log = LogFactory.getLog(joinPoint.getSignature().getDeclaringTypeName());
		log.debug("Returning from the method " + joinPoint.getSignature().getName() + "()");
	}

	@AfterThrowing(pointcut = "serviceLayerLogs()", throwing = "error")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
		log = LogFactory.getLog(joinPoint.getSignature().getDeclaringTypeName());
		log.error(error.toString());
	}

}

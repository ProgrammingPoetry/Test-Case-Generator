package com.jntu.logging;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.jntu.constants.ApplicationConstants;

@Aspect
@Component
public class ControllerLogs {

	private static Logger log;

	@Pointcut("execution(* com.jntu.controller.*.*(..))")
	private void controllerLogs() {
	}

	@Before("controllerLogs()")
	public void beforeAdvice(JoinPoint joinPoint) {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringTypeName());
		log.info("Entered This Controller");
		log.info(joinPoint.getSignature().getName() + "() method has been invoked");
		log.info("Arguments are :" + Arrays.toString(joinPoint.getArgs()));
	}

	@SuppressWarnings("unchecked")
	@AfterReturning(pointcut = "controllerLogs()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringTypeName());
		log.info("Returning response status : " + ((Map<String, String>) result).get(ApplicationConstants.STATUS));
	}

	@AfterThrowing(pointcut = "controllerLogs()", throwing = "error")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
		log = Logger.getLogger(joinPoint.getSignature().getDeclaringTypeName());
		log.severe(error.toString());
	}

	/*
	 * @After("controllerLogs()") public void afterAdvice(){
	 * System.out.println(); }
	 * 
	 * 
	 * @Around("controllerLogs()") public void aroundAdvice(ProceedingJoinPoint
	 * pjp){ System.out.println(); }
	 */
}

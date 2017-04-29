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
public class ControllerLogs {

	private static Log log;
	
	@Pointcut("execution(* com.jntu.controller.*.*(..))")
	private void controllerLogs() {
	}

	@Before("controllerLogs()")
	public void beforeAdvice(JoinPoint joinPoint) {
		log = LogFactory.getLog(joinPoint.getSignature().getDeclaringTypeName());
		log.info("Entered This Controller");
		log.debug(joinPoint.getSignature().getName() + "() method has been invoked");
		log.trace("Arguments are :" + Arrays.toString(joinPoint.getArgs()));
	}

	@SuppressWarnings("unchecked")
	@AfterReturning(pointcut = "controllerLogs()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		log = LogFactory.getLog(joinPoint.getSignature().getDeclaringTypeName());
		
		// ERROR is in the next line here (Resolve it Rakesh) Right now I'm commenting it out
		// Reason: If the below line is uncommented, the index.jsp page is not getting displayed when the user requests it using: localhost:5010/index
		// It is giving ClassCastException from String to Map<String,String>
		
		
		// log.info("Returning response status : " + ((Map<String, String>) result).get(ApplicationConstants.STATUS));
	}

	@AfterThrowing(pointcut = "controllerLogs()", throwing = "error")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
		log = LogFactory.getLog(joinPoint.getSignature().getDeclaringTypeName());
		log.error(error.toString());
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

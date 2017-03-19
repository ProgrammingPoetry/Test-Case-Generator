package com.jntu.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.jntu.controller.ArrayController;

@Aspect
@Component
public class ServiceMonitor {

	private static Logger log = Logger.getLogger(ArrayController.class.getName());

	@Before("execution(* com.jntu.Controller.*.*(..))")
	public void logAsEnteredAController(JoinPoint joinPoint) {
		log.info("Entered Controller: " + joinPoint);
	}

	@AfterReturning("execution(* com.jntu.Controller.*.*(..))")
	public void logControllers(JoinPoint joinPoint) {
		log.info("Completed: " + joinPoint);
	}

	@Before("execution(* com.jntu.service.*.*.*(..))")
	public void logAsEnteredAServiceMethod(JoinPoint joinPoint) {
		log.info("Entered a ServiceMethod: " + joinPoint);
	}

	@AfterReturning("execution(* com.jntu.service.*.*.*(..))")
	public void logServiceImpl(JoinPoint joinPoint) {
		log.info("Completed: " + joinPoint);
	}

	@Before("execution(* com.jntu.random.*.*.*(..))")
	public void logAsEnteredARandomMethod(JoinPoint joinPoint) {
		log.info("Entered a RandomMethod: " + joinPoint);
	}

	@AfterReturning("execution(* com.jntu.random.*.*.*(..))")
	public void logRandomImpl(JoinPoint joinPoint) {
		log.info("Completed: " + joinPoint);
	}
}

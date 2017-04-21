package com.jntu.aop;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.jntu.annotations.Validate;
import com.jntu.constants.ApplicationConstants;

@Aspect
@Component
public class ValidationHandler {
	@SuppressWarnings("unchecked")
	@Around("@annotation(category)")
	public Map<String, String> doValidation(ProceedingJoinPoint pjp,Validate category) throws Throwable {
		// TODO validation logic here
		long startTime = System.currentTimeMillis();
		Map<String, String> result = (Map<String, String>) pjp.proceed();
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		result.put(ApplicationConstants.TIME_TAKEN, String.valueOf(timeTaken) + " ms");

		return result;
	}
}

package com.jmjbrothers.first_spring.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(* com.jmjbrothers.first_spring.service.*.*(..))")
	public void servicePointCut() {

	}

	@Pointcut("execution(* com.jmjbrothers.first_spring.controller.*.*(..))")
	public void controllerPointCut() {

	}

	@Before("servicePointCut()")
	public void logBeforeService(JoinPoint joinpoint) {

		log.info("Starting service method: {} with arguments: {}", joinpoint.getSignature().getName(),
				Arrays.toString(joinpoint.getArgs()));
	}

	@AfterReturning(pointcut = "servicePoinCut()", returning = "result")
	public void logAfterService(JoinPoint joinPoint, Object result) {
		log.info("Service method: {} completed with result: {}", joinPoint.getSignature().getName(), result);
	}

	@AfterThrowing(pointcut = "servicePointCut()", throwing = "exception")
	public void logServiceException(JoinPoint joinPoint, Exception exception) {
		log.error("Exception in service method: {} with exception: {}", joinPoint.getSignature().getName(),
				exception.getMessage());
	}

	@Around("controllerPointCut")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		log.info("Starting controller method: {}", joinPoint.getSignature().getName());

		try {
			Object resultObject = joinPoint.proceed();

			long endTime = System.currentTimeMillis();
			log.info("Controller method: {} completed in {}ms", joinPoint.getSignature().getName(),
					(endTime - startTime));
			return resultObject;
		} catch (Exception e) {
			log.error("Exception in controller method: {} with message: {}", joinPoint.getSignature().getName(),
					e.getMessage());
			throw e;
		}
	}

}

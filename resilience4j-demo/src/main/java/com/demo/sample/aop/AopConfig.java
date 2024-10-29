package com.demo.sample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AopConfig {

	@Around("@annotation(io.github.resilience4j.retry.annotation.Retry)")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("check start");
		Object proceed = joinPoint.proceed();
		log.info("check end");
		return proceed;
	}
}

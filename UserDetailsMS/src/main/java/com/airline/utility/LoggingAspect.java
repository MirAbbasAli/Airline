package com.airline.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Log Logger=LogFactory.getLog(this.getClass());
	
	@AfterThrowing(pointcut="execution(* com.airline.service.*Impl.*(..))",throwing="exception")
	public void logFromService(Exception exception) {
		Logger.error(exception.getMessage());
	}
}

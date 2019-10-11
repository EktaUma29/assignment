package com.spring.restassignment.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeCRUDAspect {

	Logger logger = Logger.getLogger(Logger.class.getName());

	@Pointcut(value = "execution(* com.spring.restassignment.rest.EmployeeRestController.*(..))||execution(* com.spring.restassignment.service.EmployeeServiceImpl.*(..))")
	public void restControllerMethods() {

	}

	@Before("restControllerMethods()")
	public void restControllerStart(JoinPoint joinPoint) {
		logger.info("\n\n" + "com.spring.restassignment.rest.EmployeeRestController." + joinPoint.getSignature().getName() + " ====Start Execution======\n\n");

	}
	
	@Before("restControllerMethods()")
	public void employeeServiceStart(JoinPoint joinPoint) {
		logger.info("\n\n" + "com.spring.restassignment.service.EmployeeServiceImpl." + joinPoint.getSignature().getName() + " *********Start Execution*********\n\n");

	}
	
	@After("restControllerMethods()")
	public void restControllerEnd(JoinPoint joinPoint) {
		logger.info("\n\n" + "com.spring.restassignment.rest.EmployeeRestController." + joinPoint.getSignature().getName() + " *********End Execution*********\n\n");

	}
	
	@After("restControllerMethods()")
	public void employeeServiceEnd(JoinPoint joinPoint) {
		logger.info("\n\n" + "com.spring.restassignment.service.EmployeeServiceImpl." + joinPoint.getSignature().getName() + " *********End Execution*********\n\n");

	}
	
	
	@AfterThrowing("restControllerMethods()")
	public void restControllerThrowException(JoinPoint joinPoint) {
		logger.info("\n\n" + "com.spring.restassignment.rest.EmployeeRestController." + joinPoint.getSignature().getName() + " ********* Throw Exception *********\n\n");

	}
	
	@AfterThrowing("restControllerMethods()")
	public void employeeServicThrowException(JoinPoint joinPoint) {
		logger.info("\n\n" + "com.spring.restassignment.service.EmployeeServiceImpl." + joinPoint.getSignature().getName() + " ********* Throw Exception*********\n\n");

	}
	
	@AfterReturning(value = "restControllerMethods()", returning="retVal")
	public void restControllerAfterReturing(JoinPoint joinPoint, Object retVal) {
		logger.info("\n\n" + "com.spring.restassignment.rest.EmployeeRestController." + joinPoint.getSignature().getName() + " ********* Execution After Returning  *********\n\n");
		logger.info("\n" + retVal + "\n\n");
	}
	
	@AfterReturning(value = "restControllerMethods()", returning="retVal")
	public void employeeServicAfterReturning(JoinPoint joinPoint, Object retVal) {
		logger.info("\n\n" + "com.spring.restassignment.service.EmployeeServiceImpl." + joinPoint.getSignature().getName() + " ********* Execution After Returning *********\n\n");
		
		logger.info("\n" + retVal + "\n\n");
	}
	
}

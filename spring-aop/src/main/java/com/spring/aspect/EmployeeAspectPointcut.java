package com.spring.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class EmployeeAspectPointcut {

	//Pointcut on all getters
	//@Pointcut("execution()")

	//Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(com.spring.service)")
	public void allMethodsPointcut(){
		System.out.println("executing a service...");
	}
}

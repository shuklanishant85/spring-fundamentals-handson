package com.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {

	@Before(value = "execution(public String getName())")
	public void getNameAdvice(){
		System.out.println("Executing advice on getName()");
	}
	
	@Before(value = "execution(* com.spring.service.*.get*())")
	public void getServiceAdvice(){
		System.out.println("Service method getter called");
	}
	
}

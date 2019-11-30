package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMainClass {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
		MyService myService = (MyService) context.getBean("myService");
		myService.log("into my service");
		System.out.println(" My Service hashcode : "+myService.hashCode());
	}

}

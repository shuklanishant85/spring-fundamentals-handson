package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.EmployeeService;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		EmployeeService service = (EmployeeService) context.getBean("employeeService");
		System.out.println("employee name : "+service.getEmployee().getName());
		service.getEmployee().setName("shukla");
		System.out.println("employee name : "+service.getEmployee().getName());
		service.getEmployee().throwException();
		((ClassPathXmlApplicationContext) context).close();
	}
}

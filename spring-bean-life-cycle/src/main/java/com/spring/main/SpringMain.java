package com.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.EmployeeService;

public class SpringMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
		employeeService.displayEmployeeName();
		context.close();
	}
}
